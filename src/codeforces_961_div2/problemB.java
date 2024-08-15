package codeforces_961_div2;

import java.util.Arrays;
import java.util.Scanner;

public class problemB {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int tests = sc.nextInt();
    while (tests-- > 0) {
      int n = sc.nextInt();
      long m = sc.nextLong();
      long[] petals = new long[n];
      for (int i = 0; i < n; i++) {
        petals[i] = sc.nextLong();
      }
      Arrays.sort(petals);
      long cost = 0;
      long petal_count = 0, res = 0;
      int i = 0, j = 0;
      //      while (j < n) {
      //        cost += petals[j];
      //        petal_count += petals[j];
      //        while (i < j && (cost > m || petals[j] - petals[i] > 1)) {
      //          cost -= petals[i];
      //          petal_count -= petals[i];
      //          i++;
      //        }
      //        if (cost <= m) {
      //          res = Math.max(petal_count, res);
      //        }
      //        j++;
      //      }
      while (i < n) {
        j = i;
        while (j < n && petals[j] == petals[i]) {
          j++;
        }
        int l = j;
        while (l < n && petals[l] == petals[i] + 1) {
          l++;
        }
        for (int c = 0; c <= j - i; c++) {
          if (petals[i] * c > m) {
            continue;
          }
          long val = c * petals[i];
          long temp = Math.min((m - val) / (petals[i] + 1), l - j);
          val += (temp * (petals[i] + 1));
          res = Math.max(res, val);
        }
        i = j;
      }
      System.out.println(res);
    }
  }
}
