package codeforces_956_div2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class problemA {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int tests = sc.nextInt();
    for (int test = 0; test < tests; test++) {
      int n = sc.nextInt();
      List<Integer> res = new ArrayList<>();
      for (int i = 1; i <= n; i++) {
        System.out.print(i * 2);
        System.out.print(" ");
      }
      System.out.println();
    }
  }
}
