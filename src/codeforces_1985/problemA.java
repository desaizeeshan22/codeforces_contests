package codeforces_1985;

import java.util.Scanner;

public class problemA {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    for (int i = 0; i < n; i++) {
      StringBuilder s1 = new StringBuilder(sc.next());
      StringBuilder s2 = new StringBuilder(sc.next());
      char temp = s1.charAt(0);
      s1.setCharAt(0, s2.charAt(0));
      s2.setCharAt(0, temp);
      System.out.print(s1);
      System.out.print(" ");
      System.out.print(s2);
      System.out.println();
    }
  }
}
