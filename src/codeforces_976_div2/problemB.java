package codeforces_976_div2;

import java.util.Scanner;

public class problemB {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int tests = sc.nextInt();
    while (tests-- > 0) {
      long n = sc.nextLong();
      if (n == 1) {
        System.out.println(2);
        continue;
      }
      long res = n;
      while (calculateOn(res) != n) {
        res++;
      }
      System.out.println(res);
    }
  }

  public static long calculateOn(long n) {
    long on = n;
    for (int i = 1; i * i <= n; i++) {
      on--;
    }
    return on;
  }
}
