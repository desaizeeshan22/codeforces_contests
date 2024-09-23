package codeforces_969_div_2;

import java.util.Scanner;

public class problemB {
  //  public static class segTree {
  //    int n, m;
  //    int[] arr;
  //    int[] seg;
  //
  //    public segTree(int n, int[] a) {
  //      this.arr = new int[n];
  //      for (int i = 0; i < n; i++) {
  //        this.arr[i] = a[i];
  //      }
  //      this.n = n;
  //      this.m = 4 * n;
  //      this.seg = new int[m];
  //      this.build(0, 0, this.n - 1);
  //    }
  //
  //    public void build(int idx, int l, int r) {
  //      if (l == r) {
  //        this.seg[idx] = this.arr[l];
  //        return;
  //      }
  //      int mid = (l + r) >> 1;
  //      this.build(2 * idx + 1, l, mid);
  //      this.build(2 * idx + 2, mid + 1, r);
  //      this.seg[idx] = Math.max(this.seg[2 * idx + 1], this.seg[2 * idx + 2]);
  //    }
  //
  //    public int query(int idx, int L, int R, int l, int r) {
  //      if (R < L || L > r) {
  //        return -1;
  //      }
  //      if (l <= L && R <= r) {
  //        return this.seg[idx];
  //      }
  //      int mid = (l + r) >> 1;
  //      int left = this.query(2 * idx + 1, L, R, l, mid);
  //      int right = this.query(2 * idx + 2, L, R, mid + 1, r);
  //      if (left == -1) {
  //        return right;
  //      }
  //      if (right == -1) {
  //        return left;
  //      }
  //      return Math.max(left, right);
  //    }
  //
  //    public void update(int pos, int lo, int hi) {
  //      for (int j = 0; j < this.n; j++) {
  //        if (this.arr[j] >= lo && this.arr[j] <= hi) {
  //          this.arr[j] += pos;
  //        }
  //      }
  //      this.build(0, 0, this.n - 1);
  //    }
  //  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int tests = sc.nextInt();
    while (tests-- > 0) {
      int n = sc.nextInt();
      int m = sc.nextInt();
      int maxElem = 0;
      int[] a = new int[n], res = new int[m];
      for (int i = 0; i < n; i++) {
        a[i] = sc.nextInt();
        maxElem = Math.max(maxElem, a[i]);
      }

      //      segTree s = new segTree(n, a);
      for (int i = 0; i < m; i++) {
        String p = sc.next();
        int pos = (p.equals("+") ? 1 : -1);
        int l = sc.nextInt();
        int r = sc.nextInt();
        if (maxElem >= l && maxElem <= r) {
          maxElem += pos;
        }
        res[i] = maxElem;
      }
      for (int elem : res) {
        System.out.print(elem + " ");
      }
      System.out.println();
    }
  }

  public static void update(int[] arr, int l, int r, int pos) {
    for (int j = 0; j < arr.length; j++) {
      if (arr[j] >= l && arr[j] <= r) {
        arr[j] += pos;
      }
    }
  }
}
