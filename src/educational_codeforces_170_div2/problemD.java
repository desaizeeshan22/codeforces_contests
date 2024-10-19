package educational_codeforces_170_div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problemD {
  public static int n, m;
  public static int[] r, pre;
  public static int[][] dp;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    r = new int[n];
    pre = new int[n + 1];
    dp = new int[n + 1][m + 1];

    StringTokenizer st2 = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      r[i] = Integer.parseInt(st2.nextToken());
      pre[i + 1] = pre[i] + (r[i] == 0 ? 1 : 0);
    }

    System.out.println(iterative());
  }

  public static int iterative() {
    for (int i = 1; i <= n; i++) {
      for (int j = Math.min(m, pre[i - 1]); j >= 0; j--) {
        int ans = 0, add = 0;
        if (r[i - 1] == 0) {
          if (j >= 1) {
            ans = dp[i - 1][j - 1];
          }
          ans = Math.max(ans, dp[i - 1][j]);
        } else if (r[i - 1] < 0) {
          add = (pre[i - 1] - j) >= Math.abs(r[i - 1]) ? 1 : 0;
          ans = dp[i - 1][j] + add;
        } else {
          add = j >= Math.abs(r[i - 1]) ? 1 : 0;
          ans = dp[i - 1][j] + add;
        }
        dp[i][j] = Math.max(ans, dp[i][j]);
      }
    }
    int res = 0;
    for (int elem : dp[n]) {
      res = Math.max(elem, res);
    }
    return res;
  }


}
