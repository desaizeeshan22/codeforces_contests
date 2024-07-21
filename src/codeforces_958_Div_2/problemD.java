package codeforces_958_Div_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class problemD {
  public static long[][] dp;
  public static long[] damage;
  public static List<List<Integer>> graph;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int test = sc.nextInt();
    while (test-- > 0) {
      int n = sc.nextInt();
      damage = new long[n + 1];
      graph = new ArrayList<>();
      graph.add(new ArrayList<>());
      for (int i = 1; i <= n; i++) {
        damage[i] = sc.nextLong();
        graph.add(new ArrayList<>());
      }
      dp = new long[20][n + 1];
      for (int k = 1; k <= n - 1; k++) {
        int u = sc.nextInt();
        int v = sc.nextInt();
        graph.get(u).add(v);
        graph.get(v).add(u);
      }
      dfs(1, -1);
      long res = Long.MAX_VALUE;
      for (int k = 0; k < 20; k++) {
        res = Math.min(res, dp[k][1]);
      }
      System.out.println(res);
    }
  }

  public static void dfs(int node, int parent) {
    for (int i = 0; i < 20; i++) {
      dp[i][node] = damage[node] * (i + 1);
    }
    for (int elem : graph.get(node)) {
      if (elem == parent) {
        continue;
      }
      dfs(elem, node);
      long min1 = Long.MAX_VALUE, min2 = Long.MAX_VALUE;
      for (int j = 0; j < 20; j++) {
        min2 = Math.min(min2, dp[j][elem]);
        if (min2 < min1) {
          long temp = min1;
          min1 = min2;
          min2 = temp;
        }
      }
      for (int i = 0; i < 20; i++) {
        long val = min1;
        if (val == dp[i][elem]) {
          val = min2;
        }
        dp[i][node] += val;
      }
    }
  }
}
