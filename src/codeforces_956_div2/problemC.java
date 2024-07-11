package codeforces_956_div2;

import java.util.Scanner;

public class problemC {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int tests = sc.nextInt();
    for (int test = 0; test < tests; test++) {
      int n = sc.nextInt();
      int[] a = new int[n], b = new int[n], c = new int[n];
      int s = 0;
      for (int i = 0; i < n; i++) {
        a[i] = sc.nextInt();
        s += a[i];
      }
      for (int i = 0; i < n; i++) {
        b[i] = sc.nextInt();
      }
      for (int i = 0; i < n; i++) {
        c[i] = sc.nextInt();
      }
      int thresh = (int) Math.ceil(s / 3);

    }
  }
}
