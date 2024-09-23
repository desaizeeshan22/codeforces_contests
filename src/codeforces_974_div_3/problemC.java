package codeforces_974_div_3;

import java.util.Arrays;
import java.util.Scanner;

public class problemC {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    long tests = sc.nextInt();
    while (tests-- > 0) {
      int n = sc.nextInt();
      long[] arr = new long[n];
      long tot = 0;

      for (int i = 0; i < n; i++) {
        arr[i] = sc.nextLong();
        tot += arr[i];
      }
      long avg = ceil_div(tot, n);
      if (n == 1) {
        System.out.println(arr[0] < avg ? 0 : -1);
        continue;
      }
      if (n == 2) {
        System.out.println(-1);
        continue;
      }

      Arrays.sort(arr);
      long i = 0, j = Long.MAX_VALUE;
      while (i < j) {
        long mid = i + (j - i) / 2;
        if (isPossible(arr, mid, tot)) {
          j = mid;
        } else {
          i = mid + 1;
        }
      }
      System.out.println(i < Long.MAX_VALUE ? i : -1);
    }
  }

  public static boolean isPossible(long[] arr, long inc, long tot) {
    int n = arr.length;
    arr[n - 1] += inc;
    long avg = ceil_div(tot + inc, n);
    long res = 0;
    for (long elem : arr) {
      if (2 * elem < avg) {
        res++;
      }
    }
    arr[n - 1] -= inc;
    return res > n / 2;
  }

  public static long ceil_div(long a, long b) {
    return a / b + ((a % b) == 0 ? 0 : 1);
  }
}
