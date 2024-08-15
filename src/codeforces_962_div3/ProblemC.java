package codeforces_962_div3;

import java.util.Scanner;

public class ProblemC {

  public static int[][] preprocess(char[] a) {
    int n = a.length;
    int[][] res = new int[n][26];
    for (int i = 0; i < n; i++) {
      res[i][a[i] - 'a']++;
    }
    for (int i = 1; i < n; i++) {
      for (int j = 0; j < 26; j++) {
        res[i][j] += res[i - 1][j];
      }
    }
    return res;
  }

  public static void main(String[] arg) {
    Scanner sc = new Scanner(System.in);
    int tests = sc.nextInt();
    while (tests-- > 0) {
      int n = sc.nextInt();
      int q = sc.nextInt();
      char[] a = sc.next().toCharArray();
      char[] b = sc.next().toCharArray();
      int[][] prefix_a = preprocess(a);
      int[][] prefix_b = preprocess(b);
      for (int i = 0; i < q; i++) {
        int l = sc.nextInt() - 1;
        int r = sc.nextInt() - 1;
        int ans = 0;
        if (l == 0) {
          for (int j = 0; j < 26; j++) {
            ans += Math.abs(prefix_a[r][j] - prefix_b[r][j]);
          }
        } else {
          for (int j = 0; j < 26; j++) {
            ans += Math.abs((prefix_a[r][j] - prefix_a[l - 1][j]) - (prefix_b[r][j] - prefix_b[l - 1][j]));
          }
        }
        System.out.println(ans / 2);
      }
    }
  }

}
