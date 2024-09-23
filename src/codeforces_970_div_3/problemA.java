package codeforces_970_div_3;

import java.util.Scanner;

public class problemA {
  public static void main(String[] arg) {
    Scanner sc = new Scanner(System.in);
    int tests = sc.nextInt();
    while (tests-- > 0) {
      int a = sc.nextInt();
      int b = sc.nextInt();
      if (a == 0 || b == 0) {
        if (a == 0) {
          System.out.println((b & 1) == 0 ? "YES" : "NO");
        } else {
          System.out.println((a & 1) == 0 ? "YES" : "NO");
        }
      } else {
        int sum_a = a;
        int sum_b = 2 * b;
        System.out.println(((sum_a + sum_b) & 1) == 0 ? "YES" : "NO");
      }
    }
  }
}
