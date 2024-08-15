package Pinely_round_4;

import java.util.*;

public class problemE {
  static final int MAX_N = 10005;
  public static boolean bipartite;
  public static List<List<Integer>> adj;
  public static int[] colors;

  public static void solve(Scanner sc) {
    int n = sc.nextInt(), m = sc.nextInt();
    adj = new ArrayList<>();
    for (int i = 0; i <= MAX_N; i++) {
      adj.add(new ArrayList<>());
    }
    for (int i = 1; i <= m; i++) {
      int u = sc.nextInt();
      int v = sc.nextInt();
      adj.get(u).add(v);
      adj.get(v).add(u);
    }
    bipartite = true;
    colors = new int[MAX_N];
    Arrays.fill(colors, 0);
    Queue<Integer> q = new LinkedList<>();
    q.add(1);
    colors[1] = 1;
    while (!q.isEmpty()) {
      int curr = q.poll();
      for (int elem : adj.get(curr)) {
        if (colors[elem] == 0) {
          colors[elem] = 3 - colors[curr];
          q.add(elem);
        } else if (colors[elem] == colors[curr]) {
          bipartite = false;
        }
      }
    }
    if (bipartite) {
      System.out.println("Bob");
      LinkedList<Integer> l1 = new LinkedList<>(), l2 = new LinkedList<>();
      for (int i = 1; i <= n; i++) {
        if (colors[i] == 1) {
          l1.add(i);
        } else {
          l2.add(i);
        }
      }
      for (int i = 1; i <= n; i++) {
        int c1 = sc.nextInt();
        int c2 = sc.nextInt();
        if ((c1 == 1 || c2 == 1) && !l1.isEmpty()) {
          System.out.println(l1.removeLast() + " " + 1);
        } else if ((c1 == 2 || c2 == 2) && !l2.isEmpty()) {
          System.out.println(l2.removeLast() + " " + 2);
        } else if (l1.isEmpty()) {
          int choose = c1 == 1 ? c2 : c1;
          System.out.println(l2.removeLast() + " " + choose);
        } else {
          int choose = c1 == 2 ? c2 : c1;
          System.out.println(l1.removeLast() + " " + choose);
        }
      }
    } else {
      System.out.println("Alice");
      for (int i = 1; i <= n; i++) {
        System.out.println(1 + " " + 2);
        int vertex, color;
        vertex = sc.nextInt();
        color = sc.nextInt();
      }
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int tests = sc.nextInt();
    while (tests-- > 0) {
      solve(sc);
    }
  }
}
