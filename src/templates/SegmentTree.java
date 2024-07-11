package templates;

public class SegmentTree {
  public long size;
  public long[] v;
  public long[] arr;

  public SegmentTree(long[] arr) {
    this.size = 4 * arr.length;
    this.v = new long[4 * arr.length];
    this.arr = arr;
    this.build(0, 0, arr.length - 1, this.arr);
  }

  public void build(int i, int l, int r, long[] arr) {
    if (l == r) {
      this.v[i] = arr[l];
      return;
    }
    int mid = l + (r - l) / 2;
    int left = 2 * i + 1;
    build(left, l, mid, arr);
    int right = 2 * i + 2;
    build(right, mid + 1, r, arr);
    this.v[i] = this.v[left] + this.v[right];
  }

  public long query(int l, int r) {
    return this.queryVal(0, 0, this.arr.length - 1, l, r);
  }

  public long queryVal(int i, int tl, int tr, int l, int r) {
    if (tl > r || tr < l) {
      return 0;
    } else if (tl >= l && tr <= r) {
      return this.v[i];
    }
    int tm = tl + (tr - tl) / 2;
    return queryVal(2 * i + 1, tl, tm, l, r) + queryVal(2 * i + 2, tm + 1, tr, l, r);
  }

  public void update(int pos, long val) {
    this.updateVal(0, pos, val, 0, this.arr.length - 1);
  }

  public void updateVal(int i, int pos, long val, int l, int r) {
    if (l == r) {
      this.arr[pos] = val;
      this.v[i] = val;
      return;
    }
    int mid = l + (r - l) / 2;
    int left = 2 * i + 1;
    int right = 2 * i + 2;
    if (pos <= mid) {
      this.updateVal(left, pos, val, l, mid);
    } else {
      this.updateVal(right, pos, val, mid + 1, r);
    }
    this.v[i] = this.v[left] + this.v[right];
  }
}
