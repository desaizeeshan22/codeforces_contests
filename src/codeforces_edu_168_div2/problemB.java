package codeforces_edu_168_div2;

import java.util.*;

public class problemB {
  public static int m;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int tests = sc.nextInt();
    while (tests-- > 0) {
      m = sc.nextInt();
      int n = 2;
      List<StringBuilder> grid = new ArrayList<>();
      for (int i = 0; i < 2; i++) {
        grid.add(new StringBuilder(sc.next()));
      }
      List<StringBuilder> copy = new ArrayList<>();
      copy.addAll(grid);
      System.out.println(solve(copy));
    }
  }

  public static int solve(List<StringBuilder> copy) {
    int res = 0;
    for (int i = 0; i < 2; i++) {
      for (int j = 0; j < m; j++) {
        if (copy.get(i).charAt(j) == '.') {
          copy.get(i).setCharAt(j, 'x');
          if (connectedComponents(copy) == 3) {
            res++;
          }
          copy.get(i).setCharAt(j, '.');
        }
      }
    }
    return res;
  }

  public static int connectedComponents(List<StringBuilder> copy) {
    int res = 0;
    boolean[][] visited = new boolean[2][m];
    for (boolean[] arr : visited) {
      Arrays.fill(arr, Boolean.FALSE);
    }
    for (int i = 0; i < 2; i++) {
      for (int j = 0; j < m; j++) {
        if (!visited[i][j] && copy.get(i).charAt(j) != 'x') {
          BFS(copy, visited, new int[] {i, j});
          res++;
        }
      }
    }
    return res;
  }


  public static void BFS(List<StringBuilder> copy, boolean[][] visited, int[] start) {
    Queue<int[]> q = new LinkedList<>();
    q.add(start);
    visited[start[0]][start[1]] = true;
    int res = 0;
    while (!q.isEmpty()) {
      int[] currIdx = q.poll();
      int r = currIdx[0];
      int c = currIdx[1];
      int[] rdirs = new int[] {0, 0, 1, -1};
      int[] cdirs = new int[] {1, -1, 0, 0};
      for (int j = 0; j < 4; j++) {
        int nRow = r + rdirs[j];
        int nCol = c + cdirs[j];
        if (Math.min(nRow, nCol) < 0 || nRow >= 2 || nCol >= m || visited[nRow][nCol] || copy.get(nRow).charAt(nCol) == 'x') {
          continue;
        }
        q.add(new int[] {nRow, nCol});
        visited[nRow][nCol] = true;
      }
    }
  }
}
