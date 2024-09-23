package codeforces_970_div_3;

import java.util.Scanner;

public class problemC {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int tests = sc.nextInt();
    while (tests-- > 0) {
      long l = sc.nextLong();
      long r = sc.nextLong();
      long diff = r - l;
      long i = 0, j = 100000;

      while (i < j) {
        long mid = (i + j + 1) / 2;
        if (mid * (mid + 1) / 2 <= diff) {
          i = mid;
        } else {
          j = mid - 1;
        }
      }

      System.out.println(i + 1);
    }

  }
}

