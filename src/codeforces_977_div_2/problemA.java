package codeforces_977_div_2;

import java.util.Arrays;
import java.util.Scanner;

public class problemA {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int tests = sc.nextInt();
    while (tests-- > 0) {
      long s = 0;
      int n = sc.nextInt();
      long[] arr = new long[n];
      for (int i = 0; i < n; i++) {
        arr[i] = sc.nextLong();
      }
      Arrays.sort(arr);
      s = arr[0];
      for (int j = 1; j < n; j++) {
        s += arr[j];
        s = s / 2;
      }
      System.out.println(s);
    }
  }
}
