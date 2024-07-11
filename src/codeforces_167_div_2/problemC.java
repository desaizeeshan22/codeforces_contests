package codeforces_167_div_2;

import java.util.Scanner;

public class problemC {
  public static int[] a, b;
  public static int n;
  public static int[] dp;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int tests = sc.nextInt();

    for (int t = 0; t < tests; t++) {
      n = sc.nextInt();
      a = new int[n];
      b = new int[n];
      for (int i = 0; i < n; i++) {
        a[i] = sc.nextInt();
      }
      for (int i = 0; i < n; i++) {
        b[i] = sc.nextInt();
      }
      int ones = 0, nones = 0;
      int rA = 0, rB = 0;
      for (int j = 0; j < n; j++) {
        if (a[j] > b[j]) {
          rA += a[j];
        } else if (b[j] > a[j]) {
          rB += b[j];
        } else if (a[j] == 1) {
          ones++;
        } else if (a[j] == -1) {
          nones++;
        }
      }
      while (ones > 0) {
        if (rA < rB) {
          rA++;
        } else {
          rB++;
        }
        ones--;
      }
      while (nones > 0) {
        if (rA > rB) {
          rA--;
        } else {
          rB--;
        }
        nones--;
      }
      System.out.println(Math.min(rA, rB));
    }

  }


}
