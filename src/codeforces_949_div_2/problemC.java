package codeforces_949_div_2;

import java.util.Scanner;

public class problemC {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int tests = sc.nextInt();
    while (tests-- > 0) {
      int n = sc.nextInt();
      long[] arr = new long[n];
      long empty = 0;
      for (int i = 0; i < n; i++) {
        arr[i] = sc.nextLong();
        if (arr[i] == -1) {
          empty++;
        }
      }
      if (empty == n) {
        fillSegment(-1, n, n, arr);
        for (long elem : arr) {
          System.out.print(elem + " ");
        }
        System.out.println();
        continue;
      }

      int lastIdx = -1;
      for (int i = 0; i <= n; i++) {
        if (i == n) {
          fillSegment(lastIdx, i, n, arr);
          lastIdx = i;
          break;
        }
        if (arr[i] != -1) {
          fillSegment(lastIdx, i, n, arr);
          lastIdx = i;
          continue;
        }
      }

      boolean isPossible = true;
      for (int i = 0; i < n - 1; i++) {
        if (arr[i] == arr[i + 1] >> 1 || arr[i + 1] == arr[i] >> 1) {
          continue;
        }
        isPossible = false;
        break;
      }
      if (isPossible) {
        for (long elem : arr) {
          System.out.print(elem + " ");
        }
      } else {
        System.out.print(-1);
      }
      System.out.println();
    }
  }

  public static void fillSegment(int l, int r, int n, long[] arr) {
    if (l == -1 && r == n) {
      for (int i = 0; i < n; i++) {
        if ((i & 1) == 1) {
          arr[i] = 2;
        } else {
          arr[i] = 1;
        }
      }
      return;
    }
    if (l == -1) {
      while (r >= 1) {
        arr[r - 1] = getVal(arr[r]);
        r--;
      }
      return;
    }
    if (r == n) {
      while (l + 1 < n) {
        arr[l + 1] = getVal(arr[l]);
        l++;
      }
      return;
    }
    while (r - l > 1) {
      if (arr[l] > arr[r]) {
        arr[l + 1] = getVal(arr[l]);
        l++;
        continue;
      }
      arr[r - 1] = getVal(arr[r]);
      r--;
    }
  }

  public static long getVal(long x) {
    if (x == 1) {
      return 2;
    }
    return x >> 1;
  }
}
