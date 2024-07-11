package codeforces_173;

import java.util.Scanner;

public class problemB {
  public static String res;
  public static int n;


  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    String res = "";
    int A_price = 0, G_price = 0;
    for (int i = 0; i < n; i++) {
      int a = sc.nextInt();
      int g = sc.nextInt();
      if (Math.abs(A_price + a - G_price) <= 500) {
        A_price += a;
        res += "A";
      } else {
        G_price += g;
        res += "G";
      }
    }
    System.out.println(res);

  }

}

