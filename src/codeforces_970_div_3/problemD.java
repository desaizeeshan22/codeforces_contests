package codeforces_970_div_3;

import java.util.Scanner;

public class problemD {
  static boolean[] visited;
  static char[] colors;


  public static void main(String[] arg) {
    Scanner sc = new Scanner(System.in);
    int tests = sc.nextInt();
    while (tests-- > 0) {
      int n = sc.nextInt();
      int[] parent = new int[n];
      visited = new boolean[n];
      int[] reachable = new int[n];
      for (int i = 0; i < n; i++) {
        int node = sc.nextInt() - 1;
        parent[node] = i;
      }
      colors = sc.next().toCharArray();
      for (int i = 0; i < n; i++) {
        if (visited[i]) {
          continue;
        }
        int cnt = 0, x = i;
        do {
          cnt += (colors[x] == '0' ? 1 : 0);
          visited[x] = true;
          x = parent[x];
        } while (x != i);
        do {
          reachable[x] = cnt;
          x = parent[x];
        } while (x != i);
      }
      for (int elem : reachable) {
        System.out.print(elem + " ");
      }
      System.out.println();
    }
  }


}
