package codeforces_965_div2;

import java.util.Scanner;

public class problemA {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int tests = sc.nextInt();
    while (tests-- > 0) {
      int x = sc.nextInt();
      int y = sc.nextInt();
      int k = sc.nextInt();
      int temp = k / 2;
      for (int i = 0; i < temp; i++) {
        System.out.println(x + i + 1 + " " + y);
        System.out.println(x - i - 1 + " " + y);
      }
      if ((k & 1) != 0) {
        System.out.println(x + " " + y);
      }
    }
  }
}
