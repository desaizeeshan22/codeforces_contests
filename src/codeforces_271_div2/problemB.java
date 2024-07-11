package codeforces_271_div2;

import java.util.Scanner;

public class problemB {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] piles = new int[n];
    int[] prefix = new int[n + 1];
    int temp = 0;
    for (int i = 1; i <= n; i++) {
      piles[i - 1] = sc.nextInt();
      temp += piles[i - 1];
      prefix[i] = temp;
    }
    int m = sc.nextInt();
    for (int j = 0; j < m; j++) {
      System.out.println(lowerBound(prefix, sc.nextInt()));
    }

  }

  public static int lowerBound(int[] arr, int val) {
    int lo = 0, hi = arr.length - 1;
    int ans = arr.length - 1;
    while (lo <= hi) {
      int mid = lo + (hi - lo) / 2;
      if (arr[mid] >= val) {
        ans = mid;
        hi = mid - 1;
      } else {
        lo = mid + 1;
      }
    }
    return ans;
  }
}
