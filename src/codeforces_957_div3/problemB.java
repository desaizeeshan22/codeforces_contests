package codeforces_957_div3;

import java.util.Arrays;
import java.util.Scanner;

public class problemB {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t-- > 0) {
      int l = sc.nextInt();
      int n = sc.nextInt();
      int[] pieces = new int[n];
      for (int i = 0; i < n; i++) {
        pieces[i] = sc.nextInt();
      }
      Arrays.sort(pieces);
      int res = 0;
      for (int i = n - 2; i >= 0; i--) {
        res = res + (2 * pieces[i] - 1);
      }
      System.out.println(res);
    }
  }
}
