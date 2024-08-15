package codeforces_964_div4;

import java.util.Scanner;

public class problemG1 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int tests = sc.nextInt();
    while (tests-- > 0) {
      int res = 2;
      int l = 2, r = 999;
      while (l <= r) {
        int mid = (l + r) >> 1;
        if (query(sc, mid, mid) == mid * mid) {
          l = mid + 1;
        } else {
          res = mid;
          r = mid - 1;
        }
      }
      System.out.println("! " + res);
    }
  }

  public static int query(Scanner sc, int a, int b) {
    System.out.println("? " + a + " " + b);
    int x = sc.nextInt();
    return x;
  }
}
