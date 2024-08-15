package codeforces_962_div3;

import java.util.Scanner;

public class ProblemB {
  public static void main(String[] arg) {
    Scanner sc = new Scanner(System.in);
    int tests = sc.nextInt();
    while (tests-- > 0) {
      int n = sc.nextInt();
      int k = sc.nextInt();
      int[][] arr = new int[n][n];
      int[][] res = new int[n / k][n / k];
      for (int i = 0; i < n; i++) {
        String s = sc.next();
        for (int j = 0; j < s.length(); j++) {
          arr[i][j] = s.charAt(j) - '0';
        }
      }
      for (int i = 0; i < n; i += k) {
        for (int j = 0; j < n; j += k) {
          int j2 = j / k;
          int i2 = i / k;
          res[i2][j2] = arr[i][j];
        }
      }
      for (int i = 0; i < n / k; i++) {
        for (int j = 0; j < n / k; j++) {
          System.out.print(res[i][j]);
        }
        System.out.println();
      }
    }

  }
}
