package codeforces_955_div2;

import java.util.Scanner;

public class problemA {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int tests = sc.nextInt();
    for (int t = 0; t < tests; t++) {
      int stA = sc.nextInt();
      int stB = sc.nextInt();

      int endA = sc.nextInt();
      int endB = sc.nextInt();
      String res;
      if (stA > stB && endA < endB || stA < stB && endA > endB) {
        res = "NO";
      } else {
        res = "YES";
      }
      System.out.println(res);
    }
  }
}
