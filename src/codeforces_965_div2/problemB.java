package codeforces_965_div2;

import java.util.Scanner;

public class problemB {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int tests = sc.nextInt();
    while (tests-- > 0) {
      int n = sc.nextInt();
      int[] arr = new int[n];
      for (int i = 0; i < n; i++) {
        arr[i] = sc.nextInt();
      }
      System.out.print(arr[n - 1] + " ");
      for (int i = 0; i < n - 1; i++) {
        System.out.print(arr[i] + " ");
      }
      System.out.println();
    }
  }
}
