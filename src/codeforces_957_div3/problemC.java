package codeforces_957_div3;

import java.util.Scanner;

public class problemC {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t-- > 0) {
      int n = sc.nextInt();
      int m = sc.nextInt();
      int k = sc.nextInt();
      int[] p = new int[n];
      for (int i = 0; i < n; i++) {
        p[i] = n - i;
      }
      reverse(p, n - m, n - 1);
      for (int elem : p) {
        System.out.print(elem);
        System.out.print(" ");
      }
      System.out.println();
    }
  }

  public static void reverse(int[] arr, int lo, int hi) {
    while (lo <= hi) {
      swap(arr, lo, hi);
      lo++;
      hi--;
    }
  }

  public static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
}
