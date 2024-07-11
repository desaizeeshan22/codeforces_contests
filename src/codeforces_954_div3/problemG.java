package codeforces_954_div3;

import java.util.Scanner;

public class problemG {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int tests = sc.nextInt();
    for (int t = 0; t < tests; t++) {
      int n = sc.nextInt();
      int[] p = new int[n];
      for (int i = 0; i < n; i++) {
        p[i] = sc.nextInt();
      }
      if (n <= 1) {
        System.out.println(0);
      } else {
        int res = 0;
        for (int i = 0; i < n; i++) {
          for (int j = i + 1; j < n; j++) {
            int temp = p[i] * p[j];
            int divisor = (i + 1) * (j + 1);
            if (temp % divisor == 0) {
              res++;
            }
          }
        }
        System.out.println(res);
      }
    }
  }
}
