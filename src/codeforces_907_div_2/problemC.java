package codeforces_907_div_2;

import java.util.Arrays;
import java.util.Scanner;

public class problemC {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int tests = sc.nextInt();
    while (tests-- > 0) {
      int n = sc.nextInt();
      long[] arr = new long[n];
      for (int i = 0; i < n; i++) {
        arr[i] = sc.nextLong();
      }
      Arrays.sort(arr);
      int r = n - 1, l = 0;
      long ans = 0, x = 0;
      while (l <= r) {
        if (l == r) {
          long y = (arr[l] - x) / 2;
          if (arr[l] < 2) {
            ans += arr[l];
          } else {
            ans += y + 1 + ((arr[l] - x) & 1);
          }
          break;
        }
        long temp = Math.min(arr[l], arr[r] - x);
        arr[l] -= temp;
        ans += temp;
        x += temp;
        if (arr[l] == 0) {
          l++;
        }
        if (arr[r] == x) {
          r--;
          x = 0;
          ans++;
        }

      }
      System.out.println(ans);
    }
  }
}
