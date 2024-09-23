package codeforces_968_div2;

import java.util.Arrays;
import java.util.Scanner;

public class problemB {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int tests = sc.nextInt();
    while (tests-- > 0) {
      int n = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < n; i++) {
        a[i] = sc.nextInt();
      }
      Arrays.sort(a);
      System.out.println(a[n / 2]);
    }
  }
}

