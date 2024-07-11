package codeforces_1985;

import java.util.Scanner;

public class problemB {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    for (int c = 0; c < t; c++) {
      int n = sc.nextInt();
      System.out.println(solution(n));
    }
  }

  public static int solution(int n) {
    int maxSum = 0;
    int res = 2;
    int rSum;
    int x;
    for (x = 2; x <= n; x++) {
      int k = n / x;
      rSum = 0;
      for (int m = 1; m <= k; m++) {
        if (m * x > n) {
          break;
        }
        rSum += m * x;
      }
      if (rSum > maxSum) {
        maxSum = rSum;
        res = x;
      }
    }
    return res;
  }
}
