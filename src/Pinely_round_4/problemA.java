package Pinely_round_4;

import java.util.Scanner;

public class problemA {


  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int tests = sc.nextInt();
    while (tests-- > 0) {
      int n = sc.nextInt();
      int[] arr = new int[n];
      for (int i = 0; i < n; i++) {
        arr[i] = sc.nextInt();
      }
      if (n == 1) {
        System.out.println(arr[0]);
        continue;
      }
      int res = 0;
      for (int i = 0; i < n; i++) {
        if (i % 2 == 0) {
          res = Math.max(res, arr[i]);
        }
      }
      System.out.println(res);
    }
  }
}
