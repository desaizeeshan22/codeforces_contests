package codeforces_976_div2;

import java.util.Scanner;

public class problemC {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int tests = sc.nextInt();
    while (tests-- > 0) {
      long b = sc.nextLong(), c = sc.nextLong(), d = sc.nextLong();
      long a = findA(b, c, d);
      System.out.println(a);
    }
  }

  public static long findA(long b, long c, long d) {
    long res = 0;
    for (int j = 0; j <= 61; j++) {
      long bBit = (b >> j) & 1;
      long cBit = (c >> j) & 1;
      long dBit = (d >> j) & 1;
      if (dBit == 1) {
        if (bBit == 0 && cBit == 1) {
          return -1;
        }
        res = res | (1L << j);
      } else {
        if (bBit == 1 && cBit == 0) {
          return -1;
        }
      }
    }
    return res;
  }
}
