package codeforces_953_div_2;

import java.util.Scanner;

public class problemE {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int tests = sc.nextInt();
    for (int test = 0; test < tests; test++) {
      int l = sc.nextInt();
      String s = sc.next();
      String t = sc.next();

      int[] prefix = new int[l + 1];

      for (int k = 0; k < l; k++) {
        prefix[k + 1] = prefix[k] + (getRange(s, k, t)[0] != -1 ? 1 : 0);
      }
      int q = sc.nextInt();
      for (int query = 0; query < q; query++) {
        int a = sc.nextInt();
        int b = sc.nextInt();
        if (b - a <= 5) {
          int res = 0;
          for (int i = a - 1; i < b; i++) {
            int[] indices = getRange(s, i, t);
            int lo = indices[0], hi = indices[1];
            if (lo >= a - 1 && hi < b) {
              res++;
            }
          }
          System.out.println(res);
        } else {
          int res = prefix[b] - prefix[a - 1];
          for (int m = a - 1; m < b; m++) {
            int[] indices = getRange(s, m, t);
            int lo = indices[0], hi = indices[1];
            if (lo != -1 && lo < a - 1 || hi >= b) {
              res--;
            }
          }
          System.out.println(res);
        }
      }
    }
  }

  public static int[] getRange(String s, int i, String t) {
    if (s.charAt(i) == '1') {
      return new int[] {i, i};
    }
    int l = -1, r = -1;
    if (i > 0 && t.charAt(i - 1) == '1') {
      l = i - 1;
    } else if (i > 1 && t.charAt(i - 1) == '0' && s.charAt(i - 2) == '0') {
      l = i - 2;
    }
    if (i < s.length() - 1 && t.charAt(i + 1) == '1') {
      r = i + 1;
    } else if (i < s.length() - 2 && t.charAt(i + 1) == '0' && s.charAt(i + 2) == '0') {
      r = i + 2;
    }
    if (l == -1) {
      r = -1;
    }
    if (r == -1) {
      l = -1;
    }
    return new int[] {l, r};
  }
}
//  auto get_range = [&] (int i) {
//    if (s[i] == '1') return make_pair(i, i);
//    int l = -1, r = -1;
//    if (i > 0 && t[i-1] == '1') l = i-1;
//    else if (i > 1 && t[i-1] == '0' && s[i-2] == '0') l = i-2;
//    if (i+1 < n && t[i+1] == '1') r = i+1;
//    else if (i+2 < n && t[i+1] == '0' && s[i+2] == '0') r = i+2;
//    if (l == -1) r = -1;
//    if (r == -1) l = -1;
//    return make_pair(l, r);
//  };




