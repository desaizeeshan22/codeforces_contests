import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution3 {
  private static final int[] rDirs = {-1, 1, 0, 0};
  private static final int[] dc = {0, 0, -1, 1};
  private static int rows, cols;
  private static char[][] grid;
  private static int[][] distanceFromObstacles;

  public static int findMaximumDistance(List<String> gridList) {
    rows = gridList.size();
    cols = gridList.get(0).length();
    grid = new char[rows][cols];
    distanceFromObstacles = new int[rows][cols];

    Queue<int[]> obstacles = new LinkedList<>();
    int[] start = {-1, -1}, end = {-1, -1};
    for (int r = 0; r < rows; r++) {
      String row = gridList.get(r);
      for (int c = 0; c < cols; c++) {
        grid[r][c] = row.charAt(c);
        distanceFromObstacles[r][c] = Integer.MAX_VALUE;

        if (grid[r][c] == 'S') {
          start = new int[] {r, c};
        } else if (grid[r][c] == 'E') {
          end = new int[] {r, c};
        } else if (grid[r][c] == '*') {
          obstacles.offer(new int[] {r, c});
          distanceFromObstacles[r][c] = 0;
        }
      }
    }

    while (!obstacles.isEmpty()) {
      int[] cell = obstacles.poll();
      for (int i = 0; i < 4; i++) {
        int nr = cell[0] + rDirs[i], nc = cell[1] + dc[i];
        if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && grid[nr][nc] != '*' && distanceFromObstacles[nr][nc] == Integer.MAX_VALUE) {
          distanceFromObstacles[nr][nc] = distanceFromObstacles[cell[0]][cell[1]] + 1;
          obstacles.offer(new int[] {nr, nc});
        }
      }
    }

    // Find path that maximizes the minimum distance from obstacles
    return bfsMaxMinDistance(start, end);
  }

  private static int bfsMaxMinDistance(int[] start, int[] end) {
    boolean[][] visited = new boolean[rows][cols];
    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[2] - a[2]); // Max-heap based on distance
    pq.offer(new int[] {start[0], start[1], distanceFromObstacles[start[0]][start[1]]});

    while (!pq.isEmpty()) {
      int[] cell = pq.poll();
      int r = cell[0], c = cell[1];
      if (visited[r][c])
        continue;
      visited[r][c] = true;

      if (r == end[0] && c == end[1])
        return cell[2]; // Found the end

      for (int i = 0; i < 4; i++) {
        int nr = r + rDirs[i], nc = c + dc[i];
        if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && !visited[nr][nc] && grid[nr][nc] != '*') {
          pq.offer(new int[] {nr, nc, Math.min(cell[2], distanceFromObstacles[nr][nc])});
        }
      }
    }

    return -1; // Path not found
  }
}
