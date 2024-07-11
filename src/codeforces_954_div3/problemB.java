package codeforces_954_div3;

import java.util.Scanner;

public class problemB {
  public static int rows, cols;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int tests = sc.nextInt();
    for (int t = 0; t < tests; t++) {
      rows = sc.nextInt();
      cols = sc.nextInt();
      int[][] grid = new int[rows][cols];
      for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
          grid[i][j] = sc.nextInt();
        }
      }
      for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
          grid[i][j] = solution(i, j, grid);
        }
      }
      for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
          System.out.print(grid[i][j]);
          System.out.print(" ");
        }
        System.out.println("");
      }
    }
  }

  public static int solution(int r, int c, int[][] grid) {
    int[] rdirs = new int[] {0, 1, -1, 0};
    int[] cdirs = new int[] {1, 0, 0, -1};
    int currElem = grid[r][c];
    int res = Integer.MIN_VALUE;
    for (int d = 0; d < 4; d++) {
      int nRow = r + rdirs[d];
      int nCol = c + cdirs[d];
      if (Math.min(nRow, nCol) < 0 || nRow >= rows || nCol >= cols) {
        continue;
      } else {
        if (currElem <= grid[nRow][nCol]) {
          return currElem;
        } else {
          res = Math.max(res, grid[nRow][nCol]);
        }
      }
    }
    return res;
  }
}
