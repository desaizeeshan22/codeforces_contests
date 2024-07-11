package Miscellaneous;

import java.util.Scanner;

public class problem_339_D {
  public static class SegTree {
    public long size;
    public long[] v;
    public long[] arr;
    public int orr;

    public SegTree(long[] arr, int n) {
      this.size = 4 * arr.length;
      this.v = new long[4 * arr.length];
      this.arr = arr;
      this.orr = n % 2 == 0 ? 0 : 1;
      this.build(0, 0, arr.length - 1, this.arr, this.orr);
    }

    public void build(int i, int l, int r, long[] arr, int orr) {
      if (l == r) {
        this.v[i] = arr[l];
        return;
      }
      int mid = l + (r - l) / 2;
      int left = 2 * i + 1;
      build(left, l, mid, arr, 1 - orr);
      int right = 2 * i + 2;
      build(right, mid + 1, r, arr, 1 - orr);
      if (orr == 1) {
        this.v[i] = this.v[left] | this.v[right];
      } else {
        this.v[i] = this.v[left] ^ this.v[right];
      }
    }

    //    public long query(int l, int r) {
    //      return this.queryVal(0, 0, this.arr.length - 1, l, r, this.orr);
    //    }
    //
    //    public long queryVal(int i, int tl, int tr, int l, int r, int orr) {
    //      if (tl > r || tr < l) {
    //        return 0;
    //      } else if (tl >= l && tr <= r) {
    //        return this.v[i];
    //      }
    //      int tm = tl + (tr - tl) / 2;
    //      if (orr == 1) {
    //        return queryVal(2 * i + 1, tl, tm, l, r, 1 - orr) | queryVal(2 * i + 2, tm + 1, tr, l, r, 1 - orr);
    //      }
    //      return queryVal(2 * i + 1, tl, tm, l, r, 1 - orr) ^ queryVal(2 * i + 2, tm + 1, tr, l, r, 1 - orr);
    //    }

    public void update(int pos, long val) {
      this.updateVal(0, pos, val, 0, this.arr.length - 1, this.orr);
    }

    public void updateVal(int i, int pos, long val, int l, int r, int orr) {
      if (l == r) {
        this.arr[pos] = val;
        this.v[i] = val;
        return;
      }
      int mid = l + (r - l) / 2;
      int left = 2 * i + 1;
      int right = 2 * i + 2;
      if (pos <= mid) {
        this.updateVal(left, pos, val, l, mid, 1 - orr);
      } else {
        this.updateVal(right, pos, val, mid + 1, r, 1 - orr);
      }
      if (orr == 1) {
        this.v[i] = this.v[left] | this.v[right];
      } else {
        this.v[i] = this.v[left] ^ this.v[right];
      }
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int cases = sc.nextInt();
    int size = 1 << n;
    long[] arr = new long[size];
    for (int i = 0; i < size; i++) {
      arr[i] = sc.nextLong();
    }
    SegTree s = new SegTree(arr, n);
    while (cases-- > 0) {
      int p = sc.nextInt() - 1;
      long val = sc.nextLong();
      s.update(p, val);
      System.out.println(s.v[0]);
    }
  }
}
