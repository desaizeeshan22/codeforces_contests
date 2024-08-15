package codeforces_964_div4;

import java.util.Scanner;

public class problemA {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int tests = sc.nextInt();
    while (tests-- > 0) {
      int s = 0;
      int k = 2;
      int num = sc.nextInt();
      while (k-- > 0) {
        s += (num % 10);
        num = num / 10;
      }
      System.out.println(s);
    }
  }
}
