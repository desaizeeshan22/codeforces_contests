package codeforces_954_div3;

import java.util.Arrays;
import java.util.Scanner;

public class problemC {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int tests = sc.nextInt();
    for (int t = 0; t < tests; t++) {
      int n = sc.nextInt();
      int m = sc.nextInt();
      String s = sc.next();
      StringBuilder res = new StringBuilder(s);
      int[] indices = new int[m];
      for (int i = 0; i < m; i++) {
        indices[i] = sc.nextInt();
      }
      String c = sc.next();
      char[] c_arr = c.toCharArray();
      Arrays.sort(c_arr);
      Arrays.sort(indices);
      int j = 0;
      for (int i = 0; i < m; i++) {
        if (i > 0 && indices[i - 1] == indices[i]) {
          continue;
        }
        res.setCharAt(indices[i] - 1, c_arr[j++]);

      }
      System.out.println(res);
    }
  }
}
