package codeforces_974_div_3;

import java.util.Scanner;

public class problemA {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int tests = sc.nextInt();
    while (tests-- > 0) {
      int n = sc.nextInt();
      int k = sc.nextInt();
      int res = 0;
      int gold_taken = 0;
      for (int i = 0; i < n; i++) {
        int gold = sc.nextInt();
        if (gold >= k) {
          gold_taken += gold;
        } else if (gold == 0 && gold_taken > 0) {
          res++;
          gold_taken--;
        }
      }
      System.out.println(res);
    }
  }
}
