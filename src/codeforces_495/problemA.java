package codeforces_495;

import java.util.Scanner;

public class problemA {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int level = 1;
    int res = 0;
    while (n > 0) {
      n -= ((level) * (level + 1)) / 2;
      level++;
      res++;
    }
    if (n == 0) {
      System.out.println(res);
    } else {
      System.out.println(res - 1);
    }
  }
}
