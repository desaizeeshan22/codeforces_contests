package codeforces_969_div_2;

import java.util.Scanner;

public class problemD {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int tests = sc.nextInt();
    while (tests-- > 0) {
      int n = sc.nextInt();
      int[] degree = new int[n + 1];

      for (int i = 0; i < n - 1; i++) {
        int u = sc.nextInt();
        int v = sc.nextInt();
        degree[u]++;
        degree[v]++;
      }
      char[] s = new char[n + 1];
      char[] in = sc.next().toCharArray();
      for (int i = 0; i < n; i++) {
        s[i + 1] = in[i];
      }
      int x = 0, y = 0, z = 0, k = 0;
      for (int i = 2; i <= n; i++) {
        if (degree[i] == 1) {
          if (s[i] == '1') {
            x++;
          } else if (s[i] == '0') {
            y++;
          } else {
            z++;
          }
        } else {
          if (s[i] == '?') {
            k++;
          }
        }
      }
      int ans = 0;
      if (s[1] == '1') {
        ans = y + (z + 1) / 2;
      } else if (s[1] == '0') {
        ans = x + (z + 1) / 2;
      } else {
        ans = Math.max(x, y) + (z + (x == y ? (k % 2) : 0)) / 2;
      }
      System.out.println(ans);
    }
  }
}
