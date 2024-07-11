package codeforces_954_div3;

import java.util.Scanner;

public class problemA {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int tests = sc.nextInt();
    for (int t = 0; t < tests; t++) {
      int a1 = sc.nextInt();
      int a2 = sc.nextInt();
      int a3 = sc.nextInt();
      int res = Integer.MAX_VALUE;
      for (int a = 1; a <= 10; a++) {
        res = Math.min(res, Math.abs(a - a1) + Math.abs(a - a2) + Math.abs(a - a3));
      }
      System.out.println(res);
    }
  }
}
