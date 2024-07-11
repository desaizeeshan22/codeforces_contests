package codeforces_495;

import java.util.Arrays;
import java.util.Scanner;

public class problemB {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    long l = sc.nextLong();
    long[] lanterns = new long[n];
    for (int i = 0; i < n; i++) {
      lanterns[i] = sc.nextInt();
    }
    Arrays.sort(lanterns);
    long res = 2 * Math.max(lanterns[0], l - lanterns[n - 1]);
    for (int j = 1; j < n; j++) {
      res = Math.max(res, lanterns[j] - lanterns[j - 1]);
    }
    System.out.println(res / 2.0);
  }
}
