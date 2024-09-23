package codeforces_968_div2;

import java.util.Arrays;
import java.util.Scanner;

public class problemD {

  static final int MAXN = 200100;
  static long[] a = new long[MAXN];
  static boolean[] vis = new boolean[MAXN];

  public static void solve() {
    Scanner scanner = new Scanner(System.in);
    long n = scanner.nextLong();
    long m = scanner.nextLong();
    long k = 0;

    while (n-- > 0) {
      int t = scanner.nextInt();
      Arrays.fill(vis, 0, t + 6, false);

      for (int i = 1; i <= t; ++i) {
        a[i] = scanner.nextLong();
        if (a[i] <= t + 4) {
          vis[(int) a[i]] = true;
        }
      }

      long mex = 0;
      while (mex < vis.length && vis[(int) mex]) {
        ++mex;
      }
      vis[(int) mex] = true;
      while (mex < vis.length && vis[(int) mex]) {
        ++mex;
      }
      k = Math.max(k, mex);
    }

    if (k >= m) {
      System.out.println((m + 1) * k);
    } else {
      long result = k * k + (m + k) * (m - k + 1) / 2;
      System.out.println(result);
    }
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int T = scanner.nextInt();
    while (T-- > 0) {
      solve();
    }
    scanner.close();
  }
}

//
//import java.util.Collections;
//import java.util.LinkedList;
//import java.util.List;
//import java.util.Scanner;
//
//public class problemD {
//  public static void main(String[] args) {
//    Scanner sc = new Scanner(System.in);
//    int tests = sc.nextInt();
//    while (tests-- > 0) {
//      int n = sc.nextInt();
//      int m = sc.nextInt();
//      long mex_init = 0, s_mex_init = 0;
//      List<LinkedList<Long>> seq = new LinkedList<>();
//      for (int i = 0; i < n; i++) {
//        int l = sc.nextInt();
//        LinkedList<Long> temp = new LinkedList<>();
//        long tempMax = 0;
//        for (int j = 0; j < l; j++) {
//          temp.add(sc.nextLong());
//          tempMax = Math.max(temp.get(j), tempMax);
//        }
//        Collections.sort(temp);
//        mex_init = Math.max(calc_mex(temp, tempMax, 0), mex_init);
//
//        seq.add(temp);
//      }
//      for (LinkedList<Long> l : seq) {
//        for (int i = 0; i <= mex_init; i++) {
//          s_mex_init = Math.max(calc_mex(l, l.getLast(), i), s_mex_init);
//        }
//      }
//      long res = 0;
//      if (s_mex_init >= m) {
//        res += (s_mex_init) * (m + 1);
//      } else {
//        res += (s_mex_init) * (s_mex_init);
//        res += ((m - s_mex_init + 1) * (m + s_mex_init)) / 2;
//      }
//      System.out.println(res);
//    }
//  }
//
//  public static long calc_mex(LinkedList<Long> temp, long tempMax, long mex_init) {
//
//    temp.addFirst(mex_init);
//    tempMax = Math.max(mex_init, tempMax);
//    for (long i = 0; i <= tempMax; i++) {
//      if (!temp.contains(i)) {
//        temp.removeFirst();
//        return i;
//      }
//    }
//
//    temp.removeFirst();
//    return tempMax + 1;
//  }
//}
