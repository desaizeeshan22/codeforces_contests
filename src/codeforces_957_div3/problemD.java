package codeforces_957_div3;

import java.util.Scanner;

public class problemD {


  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int tests = sc.nextInt();
    while (tests-- > 0) {
      int n = sc.nextInt();
      int m = sc.nextInt();
      int k = sc.nextInt();
      String input = sc.next();
      input = "L" + input;
      input += "L";
      if (tabulation(input, k, m, n + 2)) {
        System.out.println("YES");
      } else {
        System.out.println("NO");
      }
      //      List<List<Integer>> adjList = new LinkedList<>();
      //      for (int i = 0; i < input.length(); i++) {
      //        adjList.add(new ArrayList<>());
      //      }
      //      for (int i = 0; i < input.length(); i++) {
      //        if (input.charAt(i) == 'L') {
      //          for (int j = i + 1; j <= Math.min(i + m, input.length() - 1); j++) {
      //            if (!adjList.get(i).contains(j) && input.charAt(j) != 'C') {
      //              adjList.get(i).add(j);
      //            }
      //          }
      //        } else if (input.charAt(i) == 'W') {
      //          if (!adjList.get(i).contains(Math.min(i + 1, input.length() - 1))) {
      //            adjList.get(i).add(Math.min(i + 1, input.length() - 1));
      //          }
      //        }
      //      }

      //      if (BFS(0, adjList, n + 1, k, input)) {
      //        System.out.println("YES");
      //      } else {
      //        System.out.println("NO");
      //      }

    }
  }


  public static boolean tabulation(String s, int k, int m, int size) {
    int[] dp = new int[size];
    for (int i = size - 2; i >= 0; i--) {
      if (s.charAt(i) == 'C') {
        dp[i] = Integer.MAX_VALUE;
      } else if (s.charAt(i) == 'W') {
        dp[i] = dp[i + 1] != Integer.MAX_VALUE ? dp[i + 1] + 1 : Integer.MAX_VALUE;
      } else {
        int temp = Integer.MAX_VALUE;
        for (int j = i + 1; j <= Math.min(size - 1, i + m); j++) {
          temp = Math.min(temp, dp[j]);
        }
        dp[i] = temp;
      }
    }
    return dp[0] <= k;
  }
  //
  //  public static boolean BFS(int node, List<List<Integer>> list, int target, int k, String s) {
  //    Queue<int[]> q = new LinkedList<>();
  //    q.add(new int[] {node, 0});
  //    int[] visited = new int[list.size()];
  //    visited[node] = 1;
  //    while (!q.isEmpty()) {
  //      int[] elem = q.poll();
  //      int curr = elem[0];
  //      int dist = elem[1];
  //      if (curr == target && dist <= k) {
  //        return true;
  //      }
  //      List<Integer> neighbors = list.get(curr);
  //      for (int i = 0; i < neighbors.size(); i++) {
  //        if (visited[neighbors.get(i)] != 1) {
  //          visited[neighbors.get(i)] = 1;
  //          int[] add = new int[] {neighbors.get(i), dist};
  //          if (s.charAt(curr) == 'W') {
  //            add[1]++;
  //          }
  //          q.add(add);
  //        }
  //      }
  //    }
  //    return false;
  //  }
}
