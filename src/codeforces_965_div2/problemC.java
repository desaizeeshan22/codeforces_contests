package codeforces_965_div2;

import java.util.*;
import java.util.stream.IntStream;

public class problemC {
  public static long evaluate(List<Long> A) {
    List<Long> B = new ArrayList<>();
    B.addAll(A);
    Collections.sort(B);
    int n = A.size();
    return B.get(n - 1) + B.get(n / 2 - 1);
  }

  public static void runCase(Scanner sc) {
    int N = sc.nextInt();
    long K = sc.nextLong();
    List<Long> A = new ArrayList<>(N);
    List<Integer> B = new ArrayList<>(N);

    for (int i = 0; i < N; i++) {
      A.add(sc.nextLong());
    }

    for (int i = 0; i < N; i++) {
      B.add(sc.nextInt());
    }

    int maxIndex = -1;

    for (int i = 0; i < N; i++) {
      if (B.get(i) == 1 && (maxIndex < 0 || A.get(i) > A.get(maxIndex))) {
        maxIndex = i;
      }
    }

    if (maxIndex < 0) {
      System.out.println(evaluate(A));
      return;
    }

    A.set(maxIndex, A.get(maxIndex) + K);
    long ans = evaluate(A);
    A.set(maxIndex, A.get(maxIndex) - K);
    int overallMax = IntStream.range(0, N).boxed().max(Comparator.comparing(A::get)).get();
    int need = (N + 1) / 2;

    long low = 0, high = A.get(overallMax) + K;

    while (low < high) {
      long mid = low + (high - low + 1) / 2;

      if (possible(A, B, overallMax, need, mid, K)) {
        low = mid;
      } else {
        high = mid - 1;
      }
    }

    ans = Math.max(ans, A.get(overallMax) + low);
    System.out.println(ans);
  }

  public static boolean possible(List<Long> A, List<Integer> B, int overallMax, int need, long minimum, long K) {
    List<Long> costs = new ArrayList<>();

    for (int i = 0; i < A.size(); i++) {
      if (i != overallMax) {
        if (A.get(i) >= minimum) {
          costs.add(0L);
        } else if (B.get(i) == 1) {
          costs.add(minimum - A.get(i));
        }
      }
    }

    if (costs.size() < need) {
      return false;
    }

    Collections.sort(costs);
    return costs.stream().limit(need).mapToLong(Long::longValue).sum() <= K;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int tests = sc.nextInt();

    while (tests-- > 0) {
      runCase(sc);
    }

    sc.close();
  }
}
