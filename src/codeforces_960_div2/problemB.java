package codeforces_960_div2;

import java.util.Arrays;
import java.util.Scanner;

public class problemB {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int tests = sc.nextInt();
    while (tests-- > 0) {
      int n = sc.nextInt();
      int x = sc.nextInt() - 1;
      int y = sc.nextInt() - 1;
      int[] arr = new int[n + 1];
      Arrays.fill(arr, -1);
      Arrays.fill(arr, y + 1, x + 2, 1);
      int num = -1;
      for (int i = y; i >= 1; i--) {
        arr[i] = num;
        num = -num;
      }
      num = -1;
      for (int i = x + 2; i <= n; i++) {
        arr[i] = num;
        num = -num;
      }
      for (int k = 1; k <= n; k++) {
        System.out.print(arr[k]);
        System.out.print(" ");
      }
      System.out.println();
    }
  }
}
