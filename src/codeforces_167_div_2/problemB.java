package codeforces_167_div_2;

import java.util.Scanner;

public class problemB {
  public static int[][] dp;

  //  Cannot use LCS longest subsequence which appears in both a and b
  //  We want a string such that a is appears as a substring and b appears as a subsequence
  //  All chars in a and all the chars in b minus the chars which are double counted
  //  Find the longest subsequence of a which is a substring in b
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int tests = sc.nextInt();

    for (int t = 0; t < tests; t++) {
      String a = sc.next();
      String b = sc.next();
      if (a == b) {
        System.out.println(a.length());
        continue;
      }
      int interval = 0;
      int res = a.length() + b.length();
      for (int i = 0; i < b.length(); i++) {
        int temp = 0;
        int st = i;
        for (int j = 0; j < a.length(); j++) {
          if (st < b.length() && a.charAt(j) == b.charAt(st)) {
            temp++;
            st++;
          }
        }
        interval = Math.max(temp, interval);
      }
      System.out.println(res - interval);
    }
  }


}
