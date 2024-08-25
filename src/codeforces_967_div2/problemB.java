package codeforces_967_div2;

import java.util.Scanner;

public class problemB {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int tests = sc.nextInt();
    while (tests-- > 0) {
      int n = sc.nextInt();
      if ((n & 1) == 0) {
        System.out.println(-1);
        continue;
      }
      int[] p = new int[n];
      int init = 1;
      for (int i = 0; i < n / 2; i++) {
        p[i] = init;
        init++;
      }
      for (int i = n - 1; i > n / 2; i--) {
        p[i] = init;
        init++;
      }
      p[n / 2] = init;
      for (int elem : p) {
        System.out.print(elem + " ");
      }
      System.out.println();
    }
  }
}
