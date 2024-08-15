package codeforces_963_div2;

import java.util.Arrays;
import java.util.Scanner;

public class problemC {
  static final int N = 200005;
  static int n, k;
  static int[] d = new int[2 * N];

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();

    while (t-- > 0) {
      n = sc.nextInt();
      k = sc.nextInt();

      int mx = -1;
      Arrays.fill(d, 0, 2 * k, 0);

      for (int i = 0; i < n; i++) {
        int x = sc.nextInt();
        assert x >= 1;
        d[x % (2 * k)]++;
        mx = Math.max(mx, x);
      }

      int cnt = 0;
      int ans = Integer.MAX_VALUE;
      for (int i = 0; i <= k - 2; i++) {
        cnt += d[i];
      }

      for (int l = 0, r = k - 1; l < 2 * k; l++, r++) {
        if (r >= 2 * k)
          r -= 2 * k;

        cnt += d[r];
        if (cnt == n) {
          int wait = (r - mx) % (2 * k);
          if (wait < 0)
            wait += 2 * k;
          ans = Math.min(ans, mx + wait);
        }

        cnt -= d[l];
      }

      if (ans == Integer.MAX_VALUE) {
        ans = -1;
      }
      System.out.println(ans);
    }

  }
}
