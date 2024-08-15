package codeforces_964_div4;

import java.util.Arrays;
import java.util.Scanner;

public class problemC {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int tests = sc.nextInt();
    while (tests-- > 0) {
      int n = sc.nextInt();
      int s = sc.nextInt();
      int m = sc.nextInt();
      int[][] intervals = new int[n][2];
      for (int i = 0; i < n; i++) {
        int st = sc.nextInt();
        int end = sc.nextInt();
        intervals[i] = new int[] {st, end};
      }
      Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
      int ini = intervals[0][0];
      if (ini >= s) {
        System.out.println("YES");
        continue;
      }
      String res = "NO";
      int prev = intervals[0][1];
      for (int i = 1; i < n; i++) {
        if (intervals[i][0] - prev >= s) {
          res = "YES";
          break;
        }
        prev = intervals[i][1];
      }
      if (m - prev >= s) {
        res = "YES";
      }
      System.out.println(res);
    }
  }
}
