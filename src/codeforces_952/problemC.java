package codeforces_952;

import java.util.Scanner;

public class problemC {
  public static long gcd(long a, long b) {
    while (b != 0) {
      long temp = b;
      a = a % b;
      b = a;
      a = temp;
    }
    return a;
  }

  public static long lcm(long x, long y) {
    return x * y / gcd(x, y);
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    for (int test = 0; test < T; test++) {
      int n = sc.nextInt();
      int i = 0;
      long[] arr = new long[n];
      while (i < n) {
        arr[i] = sc.nextLong();
        i++;
      }
      long lcm = 1;
      for (long elem : arr) {
        lcm = lcm(lcm, elem);
      }
      long sum = 0;
      for (int j = 0; j < n; j++) {
        sum += lcm / arr[j];

      }
      if (sum >= lcm) {
        System.out.println(" ");
        System.out.print(-1);
      } else {
        System.out.println(" ");
        for (long elem : arr) {
          System.out.print(lcm / elem);
          System.out.print(" ");
        }
      }
    }
  }
}
