package codeforces_1985;

import java.util.Scanner;

public class problemG {
  public static long mod = 1000000007;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int test = sc.nextInt();
    for (int t = 0; t < test; t++) {
      int l = sc.nextInt();
      int r = sc.nextInt();
      int k = sc.nextInt();
      //      brute(l, r, k);
      long b = (long) (Math.floor(9 / k) + 1);
      System.out.println(((powExponentMod(b, r) - powExponentMod(b, l)) % mod + mod) % mod);
    }
  }

  public static long powExponentMod(long base, long power) {
    long res = 1l;
    while (power > 0) {
      if ((power & 1) != 0) {
        res = (res * base) % mod;
      }
      base = (base * base) % mod;
      power = power >> 1;
    }
    return res;
  }

  public static void brute(int l, int r, int k) {
    int lower = (int) Math.pow(10, l);
    int upper = (int) Math.pow(10, r);
    for (int num = lower; num < upper; num++) {
      if (sumDigits(k * num) == k * sumDigits(num)) {
        System.out.println(num);
      }
    }
  }

  public static int sumDigits(int number) {
    int res = 0;
    while (number != 0) {
      res += (number % 10);
      number /= 10;
    }
    return res;
  }
}
