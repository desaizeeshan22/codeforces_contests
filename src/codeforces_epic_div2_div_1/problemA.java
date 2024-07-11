package codeforces_epic_div2_div_1;

import java.util.Scanner;

public class problemA {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int tests = sc.nextInt();
    for (int test = 0; test < tests; test++) {
      int n = sc.nextInt();
      int k = sc.nextInt();
      //      int res = 0;
      if (k == 1) {
        System.out.println(n);
        continue;
      }
      int t = 1;
      while (n >= 0) {
        n--;
        if (n == 0) {
          break;
        }
        t += k;
      }
      System.out.println(t);
    }
  }
}
