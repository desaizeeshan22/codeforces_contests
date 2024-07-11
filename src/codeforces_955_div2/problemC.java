package codeforces_955_div2;

import java.util.Scanner;

public class problemC {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int tests = sc.nextInt();
    for (int t = 0; t < tests; t++) {
      int n = sc.nextInt();
      int l = sc.nextInt();
      int r = sc.nextInt();
      int[] arr = new int[n];

      int[] dp = new int[n + 1];

      for (int i = 0; i < n; i++) {
        arr[i] = sc.nextInt();
      }
      int j = 0;
      int temp = 0;
      for (int i = 0; i < n; i++) {
        temp += arr[i];
        while (temp - arr[j] >= l) {
          temp -= arr[j];
          j++;
        }
        int extra = temp >= l && temp <= r ? 1 : 0;
        dp[i + 1] = Math.max(dp[j] + extra, dp[i]);
      }


      System.out.println(dp[n]);
    }
  }
}
