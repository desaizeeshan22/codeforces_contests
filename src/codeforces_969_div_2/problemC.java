package codeforces_969_div_2;

import java.util.Arrays;
import java.util.Scanner;

public class problemC {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int tests = sc.nextInt();
    while (tests-- > 0) {
      int n = sc.nextInt();
      long a = sc.nextLong();
      long b = sc.nextLong();
      long divisor = gcd(a, b);
      long[] input = new long[n];
      for (int i = 0; i < n; i++) {
        input[i] = sc.nextLong();
        input[i] = input[i] % divisor;
      }
      Arrays.sort(input);
      long res = input[n - 1] - input[0];
      for (int i = 0; i < n - 1; i++) {
        res = Math.min(res, input[i] - input[i + 1] + divisor);
      }
      System.out.println(res);
    }
  }

  public static long gcd(long a, long b) {
    if (b == 0l)
      return a;
    return gcd(b, a % b);
  }
}
