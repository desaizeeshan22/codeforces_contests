package codeforces_967_div2;

import java.util.Arrays;
import java.util.Scanner;

public class problemC {


  public static boolean[] vis;
  public static int[] par;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int tests = sc.nextInt();
    while (tests-- > 0) {
      solve(sc);
    }
    sc.close();
  }

  public static void solve(Scanner sc) {
    int n = sc.nextInt();
    vis = new boolean[n + 1];
    Arrays.fill(vis, Boolean.FALSE);
    par = new int[n + 1];
    vis[1] = true;
    for (int i = 2; i <= n; i++) {
      if (!vis[i])
        findParent(1, i, sc);
    }

    System.out.print("! ");
    for (int i = 2; i <= n; i++) {
      System.out.print(i + " " + par[i] + " ");
    }
    System.out.println();
  }

  static void findParent(int u, int v, Scanner sc) {
    int x = query(u, v, sc);
    if (x == u || x == v) {
      par[v] = u;
      vis[v] = true;
      return;
    }

    if (!vis[x]) {
      findParent(u, x, sc);
    }
    findParent(x, v, sc);
  }

  public static int query(int u, int v, Scanner sc) {
    System.out.println("? " + u + " " + v);
    return sc.nextInt();
  }
}
