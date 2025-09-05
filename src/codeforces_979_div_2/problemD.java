package codeforces_979_div_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problemD {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int tests = Integer.parseInt(st.nextToken());
    while (tests-- > 0) {
      StringTokenizer st1 = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st1.nextToken());
      int q = Integer.parseInt(st1.nextToken());
      StringTokenizer st2 = new StringTokenizer(br.readLine());
      int[] p = new int[n];
      int[] f = new int[n];
      int mx = 0;
      for (int i = 0; i < n; i++) {
        p[i] = Integer.parseInt(st2.nextToken());
        mx = Math.max(mx, p[i]);
        f[i] = (mx == (i + 1)) ? 1 : 0;
      }
      StringBuilder s = new StringBuilder(br.readLine());
      int chks = 0;
      for (int i = 0; i < n; i++) {
        chks += check(p, i, s, f);
      }
      while (q-- > 0) {
        Integer j = Integer.parseInt(br.readLine());
        j--;
        chks -= (check(p, j, s, f) + check(p, j - 1, s, f));
        if (s.charAt(j) == 'L') {
          s.setCharAt(j, 'R');
        } else {
          s.setCharAt(j, 'L');
        }
        chks += (check(p, j, s, f) + check(p, j - 1, s, f));
        if (chks == 0) {
          System.out.println("YES");
        } else {
          System.out.println("NO");
        }
      }
    }
  }

  public static int check(int[] p, int i, StringBuilder s, int[] f) {
    if (i == p.length - 1) {
      return 0;
    }
    return (f[i] == 0 && s.charAt(i) == 'L' && s.charAt(i + 1) == 'R') ? 1 : 0;
  }
}
