package codeforces_266_div2;

import java.util.Scanner;

public class problemA {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int m = sc.nextInt();
    int a = sc.nextInt();
    int b = sc.nextInt();
    int res = a * n;
    for (int i = 1; i <= n; i++) {
      res = Math.min(res, i * b + Math.max(0, n - i * m) * a);
    }
    System.out.println(res);
  }
}
