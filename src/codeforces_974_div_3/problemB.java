package codeforces_974_div_3;

import java.util.Scanner;

public class problemB {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int tests = sc.nextInt();
    while (tests-- > 0) {
      int n = sc.nextInt();
      int k = sc.nextInt();
      int odd = 0;
      for (int i = 1; i <= n; i += 2) {
        if (i + k - 1 >= n) {
          odd++;
        }
      }
      if ((odd & 1) == 0) {
        System.out.println("YES");
      } else {
        System.out.println("NO");
      }
    }
  }

}
