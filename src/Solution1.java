public class Solution1 {
  public static void main(String[] args) {
    System.out.print(longestIncreasingPath(new int[][] {{9, 9, 4}, {6, 6, 8}, {2, 1, 1}}));
  }


  public static int rows;
  public static int cols;
  public static int[][] grid;

  public static int longestIncreasingPath(int[][] matrix) {
    rows = matrix.length;
    cols = matrix[0].length;
    grid = matrix;
    int maxSteps = (int) 1e-9;
    int[][] v = new int[rows][cols];
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        maxSteps = Math.max(maxSteps, DFS(i, j, 1, -1));
      }
    }
    return maxSteps;
  }

  public static int DFS(int r, int c, int steps, int parent) {
    boolean b = r >= rows;
    if (Math.min(r, c) < 0 || b || c >= cols || grid[r][c] <= parent) {
      return 0;
    }
    int ans = 0;
    int[] rDirs = new int[] {0, 0, 1, -1};
    int[] cDirs = new int[] {1, -1, 0, 0};
    for (int i = 0; i < 4; i++) {
      ans = Math.max(ans, DFS(r + rDirs[i], c + cDirs[i], steps, grid[r][c]));
    }
    return ++ans;
  }
}
