package codeforces_956_div2;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class problemD {
  public static class SegTreeInv {
    long[] inv;

    public SegTreeInv() {
      this.inv = new long[200002];
    }

    public long inversion(int l, int r) {
      if (l == r) {
        return this.inv[l];
      }
      int mid = l + (r - l) / 2;
      return this.inversion(l, mid) + this.inversion(mid + 1, r);
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int tests = sc.nextInt();

    while (tests-- > 0) {
      int n = sc.nextInt();

      long[] A = new long[n];
      long[] B = new long[n];
      for (int i = 0; i < n; i++) {
        A[i] = sc.nextInt();
      }
      for (int i = 0; i < n; i++) {
        B[i] = sc.nextInt();
      }
      Set<Long> temp1 = new HashSet<>();
      Set<Long> temp2 = new HashSet<>();
      for (int i = 0; i < n; i++) {
        temp1.add(A[i]);
      }
      for (int i = 0; i < n; i++) {
        temp2.add(B[i]);
      }
      SegTreeInv s1 = new SegTreeInv();
      SegTreeInv s2 = new SegTreeInv();
      long invA = 0, invB = 0;
      for (int i = 0; i < n; i++) {
        invA += s1.inversion((int) Math.min(A[i] + 1, n), n);
        invB += s2.inversion((int) Math.min(B[i] + 1, n), n);
        s1.inv[(int) A[i]] = 1;
        s2.inv[(int) B[i]] = 1;
      }
      if (temp1.equals(temp2) && ((invA & 1l) == (invB & 1l))) {
        System.out.println("YES");
      } else {
        System.out.println("NO");
      }
    }
  }

  //  public static long inversions(long[] arr, int l, int r) {
  //    if (l >= r) {
  //      return 0;
  //    }
  //    long res = 0;
  //    int mid = l + (r - l) / 2;
  //    res = inversions(arr, l, mid) + inversions(arr, mid + 1, r) + countInversions(arr, l, mid, r);
  //    return res;
  //  }

  //  public static int countInversions(long[] arr, int l, int mid, int r) {
  //    int i = l, j = mid + 1;
  //    List<Long> temp = new ArrayList<>();
  //    int res = 0;
  //    while (i <= mid && j <= r) {
  //      if (arr[i] <= arr[j]) {
  //        temp.add(arr[i++]);
  //      } else {
  //        temp.add(arr[j++]);
  //        res += (mid - i + 1);
  //      }
  //    }
  //    while (i <= mid) {
  //      temp.add(arr[i++]);
  //    }
  //    while (j <= r) {
  //      temp.add(arr[j++]);
  //    }
  //    for (int k = l; k <= r; k++) {
  //      arr[k] = temp.get(k - l);
  //    }
  //    return res;
  //  }
}

