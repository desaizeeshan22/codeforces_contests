package codeforces_1985;

import java.util.*;

public class problemH1 {
  public static class DSU {
    public int n;
    public int[] sizes;
    public int[] parents;

    public DSU(int n) {
      this.n = n;
      this.parents = new int[n];
      for (int i = 0; i < n; i++) {
        this.parents[i] = i;
      }
      this.sizes = new int[n];
      Arrays.fill(sizes, 1);
    }

    public int getAncestor(int v) {
      if (v == parents[v]) {
        return v;
      }
      this.parents[v] = getAncestor(parents[v]);
      return this.parents[v];
    }

    public void union(int a, int b) {
      int ancestorA = this.getAncestor(a);
      int ancestorB = this.getAncestor(b);
      if (ancestorA != ancestorB) {
        if (this.sizes[ancestorA] <= this.sizes[ancestorB]) {
          this.parents[ancestorB] = ancestorA;
          this.sizes[ancestorA] += this.sizes[ancestorB];
        } else {
          this.parents[ancestorA] = ancestorB;
          this.sizes[ancestorB] += this.sizes[ancestorA];
        }
      }
    }
  }

  public static int rows, cols;
  public static List<String> grid;
  public static boolean[][] visited;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int test = sc.nextInt();
    for (int t = 0; t < test; t++) {
      rows = sc.nextInt();
      cols = sc.nextInt();
      char[][] grid = new char[rows][cols];
      for (int j = 0; j < rows; j++) {
        String s = sc.next();
        for (int i = 0; i < cols; i++) {
          grid[j][i] = s.charAt(i);
        }
      }
      DSU dsu = new DSU(rows * cols);
      for (int r = 0; r < rows; r++) {
        for (int c = 0; c < cols; c++) {
          if (grid[r][c] == '#') {
            if (r >= 1 && grid[r - 1][c] == '#') {
              dsu.union(cols * r + c, cols * (r - 1) + c);
            }
            if (c >= 1 && grid[r][c - 1] == '#') {
              dsu.union(cols * r + c, cols * r + (c - 1));
            }
          }
        }
      }
      long res = 0, temp;
      for (int i = 0; i < rows; i++) {
        Set<Integer> ancestors = new HashSet<>();
        int cnt = 0;
        for (int j = 0; j < cols; j++) {
          if (grid[i][j] == '#') {
            ancestors.add(dsu.getAncestor(cols * i + j));
          } else {
            cnt++;
            if (i >= 1 && grid[i - 1][j] == '#') {
              ancestors.add(dsu.getAncestor(cols * (i - 1) + j));
            }
            if (i < rows - 1 && grid[i + 1][j] == '#') {
              ancestors.add(dsu.getAncestor(cols * (i + 1) + j));
            }
          }
        }
        temp = 0;
        for (int elem : ancestors) {
          temp += dsu.sizes[elem];
        }
        res = Math.max(res, temp + cnt);
      }
      for (int j = 0; j < cols; j++) {
        Set<Integer> ancestors = new HashSet<>();
        int cnt = 0;
        for (int i = 0; i < rows; i++) {
          if (grid[i][j] == '#') {
            ancestors.add(dsu.getAncestor(cols * i + j));
          } else {
            cnt++;
            if (j >= 1 && grid[i][j - 1] == '#') {
              ancestors.add(dsu.getAncestor(cols * i + j - 1));
            }
            if (j < cols - 1 && grid[i][j + 1] == '#') {
              ancestors.add(dsu.getAncestor(cols * i + j + 1));
            }
          }
        }
        temp = 0;
        for (int elem : ancestors) {
          temp += dsu.sizes[elem];
        }
        res = Math.max(res, temp + cnt);
      }
      //      System.out.println(bruteForce(rows, cols));
      System.out.println(res);
    }
  }

  public static int bruteForce(int rows, int cols) {
    int maxSize = 0;
    for (int r = 0; r < rows; r++) {
      for (int c = 0; c < cols; c++) {
        visited = new boolean[rows][cols];
        maxSize = Math.max(dfs(r, c, r, 0), maxSize);
        visited = new boolean[rows][cols];
        maxSize = Math.max(dfsCol(r, c, c, 0), maxSize);
      }
    }
    return maxSize;
  }

  public static int dfs(int r, int c, int rowConsideration, int size) {
    if (Math.min(r, c) < 0 || r >= rows || c >= cols || (grid.get(r).charAt(c) == '.' && r != rowConsideration) || visited[r][c] == true) {
      return size;
    }
    visited[r][c] = true;
    size++;
    size = dfs(r + 1, c, rowConsideration, size);
    size = dfs(r - 1, c, rowConsideration, size);
    size = dfs(r, c + 1, rowConsideration, size);
    size = dfs(r, c - 1, rowConsideration, size);
    return size;
  }

  public static int dfsCol(int r, int c, int colConsideration, int size) {
    if (Math.min(r, c) < 0 || r >= rows || c >= cols || (grid.get(r).charAt(c) == '.') && c != colConsideration || visited[r][c]) {
      return size;
    }
    visited[r][c] = true;
    size++;
    size = dfsCol(r + 1, c, colConsideration, size);
    size = dfsCol(r - 1, c, colConsideration, size);
    size = dfsCol(r, c + 1, colConsideration, size);
    size = dfsCol(r, c - 1, colConsideration, size);
    return size;
  }
}
