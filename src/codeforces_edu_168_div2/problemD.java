package codeforces_edu_168_div2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class problemD {
  public static int[] a;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int tests = sc.nextInt();
    while (tests-- > 0) {
      int n = sc.nextInt();
      a = new int[n + 1];
      int[] dp = new int[n + 1];
      List<List<Integer>> adj = new ArrayList<>();
      for (int i = 0; i < n; i++) {
        a[i + 1] = sc.nextInt();
        adj.add(new ArrayList<>());
      }
      adj.add(new ArrayList<>());
      for (int i = 1; i < n; i++) {
        int temp = sc.nextInt();
        adj.get(temp).add(i + 1);
      }
      dfs(1, adj, dp);
      int ans = Integer.MAX_VALUE;

      for (int elem : adj.get(1))
        ans = Math.min(ans, dp[elem]);

      System.out.println(ans + a[1]);
    }
  }

  public static void dfs(int node, List<List<Integer>> adj, int[] dp) {
    if (adj.get(node).isEmpty()) {
      dp[node] = a[node];
      return;
    }
    for (int elem : adj.get(node)) {
      dfs(elem, adj, dp);
    }
    int temp = Integer.MAX_VALUE;
    for (int elem : adj.get(node)) {
      temp = Math.min(temp, dp[elem]);
    }
    dp[node] = Math.min(temp, (temp + a[node]) / 2);
  }
}
