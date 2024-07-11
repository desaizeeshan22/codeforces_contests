package codeforces_epic_div2_div_1;

import java.util.Scanner;

public class problemC {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int tests = sc.nextInt();
    for (int t = 0; t < tests; t++) {
      int n = sc.nextInt();
      long res = 0;
      for (int j = 0; j < n; j++) {
        res = Math.max(sc.nextLong() + j, res);
      }
      System.out.println(res);
    }
  }
}
