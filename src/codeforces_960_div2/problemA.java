package codeforces_960_div2;

import java.util.Scanner;

public class problemA {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int tests = sc.nextInt();
    while (tests-- > 0) {
      int n = sc.nextInt();
      int[] mp = new int[51];
      int[] arr = new int[n];
      for (int i = 0; i < n; i++) {
        arr[i] = sc.nextInt();
        mp[arr[i]]++;
      }
      String wins = "NO";
      for (int i = 0; i < n; i++) {
        if ((mp[arr[i]] & 1) != 0) {
          wins = "YES";
        }
      }
      System.out.println(wins);
    }
  }
}
