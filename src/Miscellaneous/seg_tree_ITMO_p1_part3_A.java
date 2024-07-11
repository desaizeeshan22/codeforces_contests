package Miscellaneous;

import java.util.Scanner;

public class seg_tree_ITMO_p1_part3_A {
  public static class SegTreeInversion {
    public int n;
    public int[] inv;
    public int[] v;

    public SegTreeInversion(int[] arr) {
      this.n = arr.length + 1;
      this.inv = new int[4 * n];
      this.v = new int[n];
      for (int i = 0; i < this.n - 1; i++) {
        this.v[i] = arr[i];
      }
    }

    public void update(int i, int pos, int val, int l, int r) {
      if (l == r) {
        this.inv[i] = val;
        return;
      }
      int mid = (l + r) / 2;
      if (pos <= mid) {
        this.update(2 * i + 1, pos, val, l, mid);
      } else {
        this.update(2 * i + 2, pos, val, mid + 1, r);
      }
      this.inv[i] = this.inv[2 * i + 1] + this.inv[2 * i + 2];
    }

    public int query(int i, int l, int r, int tl, int tr) {
      if (tr < l || r < tl) {
        return 0;
      }
      if (tl >= l && tr <= r) {
        return this.inv[i];
      }
      int tm = (tl + tr) / 2;
      return this.query(2 * i + 1, l, r, tl, tm) + this.query(2 * i + 2, l, r, tm + 1, tr);
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] p = new int[n];
    for (int i = 0; i < n; i++) {
      p[i] = sc.nextInt();
    }
    int[] res = new int[n];
    SegTreeInversion s = new SegTreeInversion(p);
    for (int i = 0; i < n; i++) {
      res[i] = s.query(0, Math.min(p[i] + 1, n), n, 0, n);
      s.update(0, p[i], 1, 0, n);

    }
    for (int elem : res) {
      System.out.print(elem);
      System.out.print(" ");
    }
  }
}
