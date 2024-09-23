package codeforces_970_div_3;

import java.util.Scanner;

public class problemG {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int tests = sc.nextInt();
    while (tests-- > 0) {
      int n = sc.nextInt();
      int k = sc.nextInt();
      int[] arr = new int[n];
      int g = 0;
      for (int i = 0; i < n; i++) {
        arr[i] = sc.nextInt();
        g = gcd(g, arr[i]);
      }
      if (n == 1) {
        if (k > arr[0]) {
          System.out.println(k);
        } else {
          System.out.println(k - 1);
        }
        continue;
      }
      int[] temp = new int[n];
      for (int i = 0; i < n; i++) {
        temp[i] = g * i;
      }
      int mex = k, cnt = 0;
      for (int j = k; ; j++) {
        while (cnt < n && temp[cnt] <= j) {
          cnt++;
        }
        int missingCnt = j + 1 - cnt;
        if (missingCnt == k) {
          mex = j;
          break;
        }
      }
      System.out.println(mex);
    }
  }

  public static int gcd(int a, int b) {
    while (b != 0) {
      int temp = a;
      a = b;
      b = temp % b;
    }
    return a;
  }
}
