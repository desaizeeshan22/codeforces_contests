package codeforces_epic_div2_div_1;

import java.util.Scanner;

public class problemB {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int tests = sc.nextInt();
    for (int test = 0; test < tests; test++) {
      int n = sc.nextInt();
      long[] arr = new long[n];
      for (int i = 0; i < n; i++) {
        arr[i] = sc.nextLong();
      }
      long curr = 0;
      long res = 0;
      for (int i = 1; i < n; i++) {
        if (arr[i - 1] > arr[i]) {
          res += (arr[i - 1] - arr[i]);
          curr = Math.max(curr, arr[i - 1] - arr[i]);
          arr[i] = arr[i - 1];
        }
      }
      System.out.println(res + curr);
    }
  }
}
