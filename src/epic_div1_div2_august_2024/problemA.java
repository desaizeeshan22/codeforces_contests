package epic_div1_div2_august_2024;

import java.util.Scanner;

public class problemA {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int tests = sc.nextInt();
    while (tests-- > 0) {
      int n = sc.nextInt();
      int m = sc.nextInt();
      int k = sc.nextInt();
      System.out.println(Math.min(n, k) * Math.min(m, k));
    }
  }
}
