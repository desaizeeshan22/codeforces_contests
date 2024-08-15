package Pinely_round_4;

import java.util.Scanner;

public class problemB {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int tests = sc.nextInt();
    while (tests-- > 0) {
      int n = sc.nextInt();
      int[] b = new int[n - 1];
      int[] a = new int[n];
      boolean temp = true;
      for (int i = 0; i < n - 1; i++) {
        b[i] = sc.nextInt();
      }
      a[0] = b[0];
      a[n - 1] = b[n - 2];
      for (int i = 1; i < n - 1; i++) {
        a[i] = b[i] | b[i - 1];
        if ((a[i] & a[i - 1]) != b[i - 1]) {
          temp = false;
          break;
        }
      }
      if (temp && (a[n - 1] & a[n - 2]) != b[n - 2]) {
        temp = false;
      }
      if (!temp) {
        System.out.print(-1);
      } else {
        for (int elem : a) {
          System.out.print(elem);
          System.out.print(" ");
        }
      }
      System.out.println();
    }
  }
}
