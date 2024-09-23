package codeforces_972_div2;

import java.util.Arrays;
import java.util.Scanner;

public class problemC {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String narek = "narek";
    int tests = sc.nextInt();
    while (tests-- > 0) {
      int n = sc.nextInt();
      int m = sc.nextInt();
      int[][] dp = new int[n + 1][5];
      for (int[] arr : dp) {
        Arrays.fill(arr, (int) -1e9);
      }
      dp[0][0] = 0;
      for (int i = 1; i <= n; i++) {
        String s = sc.next();
        dp[i]=Arrays.copyOf(dp[i - 1], 5);
        for (int j = 0; j < 5; j++) {
          int ind = j;// index for elem considered (ind=0)"n",(ind=1)"a",(ind=2)"r",(ind=3)"e",(ind=4)"k" for the current string aka the current prefix state
          int score = dp[i - 1][j];  // Score without considering current string with prefixes (j=0)"",(j=1)"n",(j=2)"na",(j=3)"nar",(j=4)"nare"
          for (int k = 0; k < m; k++) {
            if (narek.indexOf(s.charAt(k)) != -1) {
              score--;
            }
            if (narek.charAt(ind) == s.charAt(k)) {
              ind++;
            }
            if (ind == 5) {
              //              If all chars found restart the sequence
              score += 10;
              ind = 0;
            }
          }
          dp[i][ind] = Math.max(dp[i][ind], score);//Update values for strings considered uptill ith value and ind prefix state
          //score stores current processed string with prefix values dp[i-1][j] using the jth prefix in the (i-1)th string
        }
      }
      System.out.println(Arrays.stream(dp[n]).max().getAsInt());
    }
  }
}
