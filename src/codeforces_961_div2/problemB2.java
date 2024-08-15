package codeforces_961_div2;

import java.util.Arrays;
import java.util.Scanner;

public class problemB2 {
  static final int N = 200020;
  static long n, m;
  static Pair[] p = new Pair[N];

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int t = scanner.nextInt();

    while (t-- > 0) {
      n = scanner.nextInt();
      m = scanner.nextLong();
      for (int i = 0; i < n; i++) {
        p[i] = new Pair();
        p[i].first = scanner.nextLong();
      }
      for (int i = 0; i < n; i++) {
        p[i].second = scanner.nextLong();
      }

      Arrays.sort(p, 0, (int) n, (a, b) -> Long.compare(a.first, b.first));

      long ans = 0;

      for (int i = 0; i < n; i++) {
        long val = Math.min(m / p[i].first, p[i].second);
        ans = Math.max(ans, val * p[i].first);
      }

      for (int i = 0; i < n - 1; i++) {
        if (p[i].first + 1 != p[i + 1].first)
          continue;

        long cur = m;

        long a = Math.min(cur / p[i].first, p[i].second);
        cur -= a * p[i].first;

        long b = Math.min(cur / p[i + 1].first, p[i + 1].second);
        cur -= b * p[i + 1].first;

        long x = Math.min(Math.min(a, p[i + 1].second - b), cur);
        cur -= x;

        ans = Math.max(ans, m - cur);
      }

      System.out.println(ans);
    }

    scanner.close();
  }

  static class Pair {
    long first;
    long second;
  }
}
