package codeforces_970_div_3;

import java.util.Scanner;

public class problemB {
  static char[][] genMatrix(int n) {
    char[][] matrix = new char[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (i == 0 || j == 0 || i == n - 1 || j == n - 1) {
          matrix[i][j] = '1';
        } else {
          matrix[i][j] = '0';
        }
      }
    }
    return matrix;
  }

  public static void main(String[] arg) {
    Scanner sc = new Scanner(System.in);
    int tests = sc.nextInt();
    while (tests-- > 0) {
      int n = sc.nextInt();
      char[] s = sc.next().toCharArray();
      int root = (int) Math.sqrt(n);
      if (root * root != n) {
        System.out.println("No");
      } else {
        boolean isPossible = true;
        char[][] matrix = genMatrix(root);
        for (int i = 0; i < root; i++) {
          for (int j = 0; j < root; j++) {
            int idx = (i) * root + j;
            if (s[idx] != matrix[i][j]) {
              isPossible = false;
              break;
            }
          }
        }
        System.out.println(isPossible ? "Yes" : "No");
      }
    }

  }
}
