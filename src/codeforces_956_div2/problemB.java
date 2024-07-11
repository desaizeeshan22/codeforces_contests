package codeforces_956_div2;

import java.util.Scanner;

public class problemB {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int tests = sc.nextInt();
    for (int test = 0; test < tests; test++) {
      int n = sc.nextInt();
      int m = sc.nextInt();
      int[][] gridA = new int[n][m];
      int[][] gridB = new int[n][m];
      for (int i = 0; i < n; i++) {
        String row = sc.next();
        for (int j = 0; j < m; j++) {
          gridA[i][j] = row.charAt(j) - '0';
        }
      }

      for (int i = 0; i < n; i++) {
        String row = sc.next();
        for (int j = 0; j < m; j++) {
          gridB[i][j] = row.charAt(j) - '0';
        }
      }

      if (isPossibleAlt(gridA, gridB, n, m)) {
        System.out.println("YES");
      } else {
        System.out.println("NO");
      }
    }
  }

  public static boolean isPossibleAlt(int[][] gridA, int[][] gridB, int n, int m) {
    for (int i = 0; i < n - 1; i++) {
      for (int j = 0; j < m - 1; j++) {
        if (gridA[i][j] != gridB[i][j]) {
          int diff = (gridB[i][j] - gridA[i][j] + 3) % 3;
          if (diff == 1) {
            gridA[i][j] = (gridA[i][j] + 1) % 3;
            gridA[i + 1][j + 1] = (gridA[i + 1][j + 1] + 1) % 3;
            gridA[i][j + 1] = (gridA[i][j + 1] + 2) % 3;
            gridA[i + 1][j] = (gridA[i + 1][j] + 2) % 3;
          } else {
            gridA[i][j] = (gridA[i][j] + 2) % 3;
            gridA[i + 1][j + 1] = (gridA[i + 1][j + 1] + 2) % 3;
            gridA[i][j + 1] = (gridA[i][j + 1] + 1) % 3;
            gridA[i + 1][j] = (gridA[i + 1][j] + 1) % 3;
          }
        }
      }
    }
    for (int i = 0; i < n; i++) {
      if (gridA[i][m - 1] != gridB[i][m - 1]) {
        return false;
      }
    }
    for (int j = 0; j < m; j++) {
      if (gridA[n - 1][j] != gridB[n - 1][j]) {
        return false;
      }
    }
    return true;
  }

  public static boolean isPossible(int[][] gridA, int[][] gridB, int n, int m) {
    for (int r = n - 1; r >= 1; r--) {
      for (int c = m - 1; c >= 1; c--) {
        if (gridA[r][c] != gridB[r][c]) {
          int d = (gridB[r][c] - gridA[r][c] + 3) % 3;
          gridA[r][c] = gridB[r][c];
          gridA[r][c - 1] = (gridA[r][c - 1] + 2 * d) % 3;
          gridA[r - 1][c - 1] = (gridA[r - 1][c - 1] + d) % 3;
          gridA[r - 1][c] = (gridA[r - 1][c] + 2 * d) % 3;
        }
      }
    }
    for (int r = 0; r < n; ++r) {
      if (gridA[r][0] != gridB[r][0])
        return false;
    }
    for (int c = 0; c < m; ++c) {
      if (gridA[0][c] != gridB[0][c])
        return false;
    }
    return true;
  }
}
