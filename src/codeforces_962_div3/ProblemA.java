package codeforces_962_div3;

import java.util.Scanner;

public class ProblemA {
  public static void main(String[] arg) {
    Scanner sc = new Scanner(System.in);
    int tests = sc.nextInt();
    while (tests-- > 0) {
      int n = sc.nextInt();
      int res = 0;
      while (n > 0) {
        if (n >= 4) {
          int temp = n / 4;
          n -= 4 * temp;
          res += temp;
        } else if (n >= 2) {
          int temp = n / 2;
          n -= 2 * temp;
          res += temp;
        }
        if (n <= 1) {
          break;
        }
      }
      System.out.println(res);
    }
  }
}
