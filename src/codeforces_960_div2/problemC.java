package codeforces_960_div2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class problemC {
  public static long res;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int tests = sc.nextInt();
    while (tests-- > 0) {
      int n = sc.nextInt();
      long[] arr = new long[n];
      res = 0;
      for (int i = 0; i < n; i++) {
        arr[i] = sc.nextInt();
      }
      doit(arr, n);
      doit(arr, n);
      for (int i = n - 1; i >= 0; i--) {
        res += (n - i) * arr[i];
      }
      System.out.println(res);
    }
  }

  public static void doit(long[] arr, long n) {
    long mx = 0l;
    long temp = 0l;
    Map<Long, Long> mp = new HashMap<>();
    for (int i = 0; i < n; i++) {
      long val = arr[i];
      temp += val;
      mp.put(val, mp.getOrDefault(val, 0l) + 1);
      if (mp.get(val) >= 2) {
        mx = Math.max(mx, val);
      }
      arr[i] = mx;
    }
    res += temp;
  }
}
