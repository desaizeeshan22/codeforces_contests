package Miscellaneous;

public class PrefixSum2D {

  public static void main(String[] args) {
    int[][] arr = {{1, 2, -1}, {3, -2, 4}, {0, 1, -3}};
    int[][] p = prefixSum(arr, 3, 3);
  }

  public static int[][] prefixSum(int[][] arr, int m, int n) {
    int[][] p = new int[m + 1][n + 1];
    for (int i = 1; i <= m; i++) {
      for (int j = 1; j <= n; j++) {
        p[i][j] = p[i - 1][j] + p[i][j - 1] - p[i - 1][j - 1] + arr[i - 1][j - 1];
      }
    }
    return p;
  }
}


