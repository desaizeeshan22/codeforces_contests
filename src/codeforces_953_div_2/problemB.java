package codeforces_953_div_2;

import java.util.Scanner;

public class problemB {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int test = sc.nextInt();
    for (int t = 0; t < test; t++) {
      long n = sc.nextLong();
      long a = sc.nextLong();
      long b = sc.nextLong();
      if (a >= b) {
        System.out.println(a * n);
      } else {
        long ind = Math.min(n, b - a);
        long res = a * (n - ind) + b * ind - (ind * (ind + 1)) / 2 + ind;

        System.out.println(res);
      }
    }
  }


}
