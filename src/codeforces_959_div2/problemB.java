package codeforces_959_div2;

import java.util.Scanner;

public class problemB {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int tests = sc.nextInt();
    while (tests-- > 0) {
      int n = sc.nextInt();
      String s = sc.next();
      String t = sc.next();
      int[] s_arr = new int[n];
      int[] t_arr = new int[n];
      for (int i = 0; i < n; i++) {
        s_arr[i] = s.charAt(i) - '0';
        t_arr[i] = t.charAt(i) - '0';
      }
      String res = "YES";
      for (int j = 0; j < n && s_arr[j] == 0; j++) {
        if (t_arr[j] == 1) {
          res = "NO";
          break;
        }
      }
      System.out.println(res);
    }
  }
}
