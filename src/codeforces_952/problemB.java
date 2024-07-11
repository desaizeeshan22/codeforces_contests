package codeforces_952;

import java.util.Scanner;

public class problemB {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    for (int test = 0; test < T; test++) {
      int x = sc.nextInt();
      int y = sc.nextInt();
      int p = x ^ y;
      System.out.println(p & -p);
    }
  }
}
