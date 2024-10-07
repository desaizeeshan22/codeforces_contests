package codeforces_976_div2;

import java.util.Scanner;

public class problemA {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int tests = sc.nextInt();
    while (tests-- > 0) {
      long n = sc.nextLong();
      long k = sc.nextLong();
      if (n < k || k == 1) {
        System.out.println(n);
        continue;
      }

      long res = 0;
      while (n > 0) {
        res += n % k;
        n /= k;
      }
      System.out.println(res);
    }

  }

}
