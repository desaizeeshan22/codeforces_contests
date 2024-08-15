package educational_codeforces_169;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class problemC {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int tests = sc.nextInt();
    while (tests-- > 0) {
      int n = sc.nextInt();
      long k = sc.nextLong();
      PriorityQueue<Long> pq = new PriorityQueue<>();
      long maxElem = 0;
      long[] arr = new long[n];
      for (int i = 0; i < n; i++) {
        long temp = sc.nextLong();
        arr[i] = temp;
      }
      Arrays.sort(arr);
      long res = 0;
      for (int i = 0; i < n - 1; i++) {
        if ((i & 1) == 1) {
          res += arr[i];
        } else {
          long d = Math.min(arr[i + 1] - arr[i], k);
          arr[i] += d;
          k -= d;
          res -= arr[i];
        }
      }
      System.out.println(res);
    }
  }
}
