package codeforces_959_div2;

import java.util.Scanner;

public class problemA {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int tests = sc.nextInt();
    while (tests-- > 0) {
      int n = sc.nextInt();
      int m = sc.nextInt();
      int[][] mat = new int[n][m];
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
          mat[i][j] = sc.nextInt();
        }
      }
      if (n == 1 && m == 1) {
        System.out.println(-1);
        continue;
      }
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
          System.out.print(mat[(i + 1) % n][(j + 1) % m]);
          System.out.print(" ");
        }
        System.out.println();
      }
    }
  }
}
