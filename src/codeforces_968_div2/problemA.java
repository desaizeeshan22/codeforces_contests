package codeforces_968_div2;

import java.util.Scanner;

public class problemA {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int tests = sc.nextInt();
    while (tests-- > 0) {
      int n = sc.nextInt();
      String s = sc.next();
      if (s.charAt(0) == s.charAt(n - 1)) {
        System.out.println("NO");
      } else {
        System.out.println("YES");
      }
    }
  }
}

