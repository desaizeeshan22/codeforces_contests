package codeforces_958_Div_2;

import java.util.Scanner;

public class problemA {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int lines = sc.nextInt();
    while (lines-- > 0) {
      int n = sc.nextInt();
      int k = sc.nextInt();
      int res = (n - 1) / (k - 1) + Math.min((n - 1) % (k - 1), 1);
      System.out.println(res);
    }
  }
}
