package codeforces_961_div2;

import java.util.Scanner;

public class problemA {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int tests = sc.nextInt();
    while (tests-- > 0) {
      int n = sc.nextInt();
      int k = sc.nextInt();
      int temp = k;
      int res = 1;
      if (k <= n) {
        System.out.println((k > 0) ? 1 : 0);
        continue;
      }
      temp -= n;
      int curr = n - 1;
      while (temp > 0) {
        temp -= curr;
        res++;
        if (temp <= 0) {
          break;
        }
        temp -= curr;
        res++;
        curr--;
      }
      System.out.println(res);
    }

  }
}

