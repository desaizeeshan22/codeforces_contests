package codeforces_960_div2;

import java.util.Scanner;

public class problemD {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int tests = sc.nextInt();
    while (tests-- > 0) {
      int n = sc.nextInt();
      int[] arr = new int[n];
      int[][] dp = new int[n + 1][4];
      for (int i = 0; i < n; i++) {
        arr[i] = sc.nextInt();
      }
      for (int i = 1; i <= n; i++) {
        for (int j = 0; j < 4; j++) {
          dp[i][j] = Integer.MAX_VALUE;
        }
      }
      dp[0][0] = 0;
      for (int i = 1; i <= n; i++) {
        dp[i][0] = dp[i - 1][0] + (arr[i - 1] > 0 ? 1 : 0);
        if (i == 1) {
          if (arr[i - 1] <= 2) {
            dp[i][1] = 1;
          }
          continue;
        }
        if (arr[i - 1] >= 5) {
          continue;
        }
        dp[i][0] = Math.min(dp[i][0], dp[i - 1][3]);
        dp[i][1] = Math.min(dp[i][1], dp[i - 1][2] == Integer.MAX_VALUE ? Integer.MAX_VALUE : dp[i - 1][2] + 1);
        dp[i][2] = Math.min(dp[i][2], dp[i - 1][1] == Integer.MAX_VALUE ? Integer.MAX_VALUE : dp[i - 1][1] + 1);
        dp[i][3] = Math.min(dp[i][3], dp[i - 1][0] == Integer.MAX_VALUE ? Integer.MAX_VALUE : dp[i - 1][0] + 2);
        if (arr[i - 1] <= 2) {
          dp[i][0] = Math.min(dp[i][0], dp[i - 1][1]);
          dp[i][1] = Math.min(dp[i][1], dp[i - 1][0] == Integer.MAX_VALUE ? Integer.MAX_VALUE : dp[i - 1][0] + 1);
        }
      }
      System.out.println(dp[n][0]);
    }
  }
}
