package codeforces_959_div2;

import java.util.Scanner;

public class problemC {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int tests = sc.nextInt();
    while (tests-- > 0) {
      int n = sc.nextInt();
      int k = sc.nextInt();
      long[] arr = new long[n];
      long temp = 0;
      long[] prefix = new long[n + 1];
      for (int i = 0; i < n; i++) {
        arr[i] = sc.nextLong();
        temp += arr[i];
        prefix[i + 1] = temp;
      }
      long[] dp = new long[n + 2];
      for (int i = n; i >= 1; i--) {
        int p = search(i, n, prefix, k, arr);
        if (p == -1) {
          dp[i] = n - i + 1;
        } else {
          dp[i] = dp[p + 1] + p - i;
        }

      }
      long res = 0;
      for (long elem : dp) {
        res += elem;
      }
      System.out.println(res);
    }

  }

  public static int search(int l, int r, long[] prefix, int k, long[] arr) {
    int lo = l;
    long diff = 0;
    if (l >= 1) {
      diff = arr[l - 1];
    }
    int hi = r;
    int ans = -1;
    while (lo <= hi) {
      int mid = lo + (hi - lo) / 2;
      if (prefix[mid] - prefix[l] + diff > k) {
        ans = mid;
        hi = mid - 1;
      } else {
        lo = mid + 1;
      }
    }
    return ans;
  }
}
