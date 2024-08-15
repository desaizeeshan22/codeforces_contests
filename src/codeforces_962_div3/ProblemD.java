package codeforces_962_div3;

import java.util.Scanner;

public class ProblemD {
  public static void main(String[] arg) {
    Scanner sc = new Scanner(System.in);
    int tests = sc.nextInt();
    while (tests-- > 0) {
      long n = sc.nextLong();
      long x = sc.nextLong();
      long ans = 0;
      for (int a = 1; a <= n; a++) {
        for (int b = 1; (n >= (a * b)) && x > (a + b); b++) {
          long check2 = (n - a * b) / (a + b);
          long check1 = x - a - b;
          ans += (Math.min(check1, check2));
        }
      }
      System.out.println(ans);
    }
  }
}
