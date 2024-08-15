package codeforces_964_div4;

import java.util.Scanner;

public class problemG2 {


  private static void solve(Scanner scanner) {
    int l = 1, r = 999;
    while (r - l > 2) {
      int a = (2 * l + r) / 3;
      int b = (2 * r + l) / 3;
      System.out.println("? " + a + " " + b);
      System.out.flush();
      int resp = scanner.nextInt();

      if (resp == (a + 1) * (b + 1)) {
        r = a;
      } else if (resp == a * b) {
        l = b;
      } else {
        l = a;
        r = b;
      }
    }
    if (r - l == 2) {
      System.out.println("? 1 " + (l + 1));
      int resp = scanner.nextInt();

      if (resp == l + 1) {
        l = l + 1;
      } else {
        r = l + 1;
      }
    }
    System.out.println("! " + r);
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int tt = scanner.nextInt();
    for (int i = 1; i <= tt; i++) {
      solve(scanner);
    }
  }
}
