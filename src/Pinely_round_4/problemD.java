package Pinely_round_4;

import java.util.Scanner;

public class problemD {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int tests = sc.nextInt();
    while (tests-- > 0) {
      int n = sc.nextInt();
      if (n == 1) {
        System.out.println(1);
        System.out.print(1);
      } else if (n == 2) {
        System.out.println(2);
        System.out.print("1 2");
      } else if (n == 3) {
        System.out.println(2);
        System.out.print("1 2 2");
      } else if (n == 4) {
        System.out.println(3);
        System.out.print("1 2 2 3");
      } else if (n == 5) {
        System.out.println(3);
        System.out.print("1 2 2 3 3");
      } else {
        System.out.println(4);
        for (int i = 1; i <= n; i++) {
          System.out.print(i % 4 + 1);
          System.out.print(" ");
        }
      }
      System.out.println();
    }
  }


}
