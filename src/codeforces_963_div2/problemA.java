package codeforces_963_div2;

import java.util.Scanner;

public class problemA {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int tests = sc.nextInt();
    while (tests-- > 0) {
      int n = sc.nextInt();
      int[] mp = new int[4];
      String s = sc.next();
      for (int i = 0; i < s.length(); i++) {
        if (s.charAt(i) == '?') {
          continue;
        }
        mp[s.charAt(i) - 'A']++;
      }
      int res = 0;
      for (int i = 0; i < 4; i++) {
        int temp = mp[i];
        if (temp >= n) {
          temp = n;
        }
        res += temp;
      }
      System.out.println(res);
    }
  }
}
