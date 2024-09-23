package codeforces_969_div_2;

import java.util.Scanner;

public class problemA {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int tests = sc.nextInt();
    while (tests-- > 0) {
      int l = sc.nextInt();
      int r = sc.nextInt();
      int ans = 0;
      for (int i = l; i <= r; i++) {
        ans += ((i & 1) == 1 ? 1 : 0);
      }
      System.out.println(ans/2);
    }
  }
}
