package codeforces_967_div2;

import java.util.Scanner;

public class problemD {

  public static boolean optimize(int a, int idx, int[] res) {
    if ((idx & 1) == 1) {
      return a < res[idx];
    }
    return a > res[idx];
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int tests = sc.nextInt();
    while (tests-- > 0) {
      int n = sc.nextInt();
      int[] a = new int[n];
      int[] cnt = new int[n + 1];
      for (int i = 0; i < n; i++) {
        int temp = sc.nextInt();
        a[i] = temp;
        cnt[temp]++;
      }
      boolean[] seen = new boolean[n + 1];
      int[] res = new int[n + 1];
      int j = 0;
      for (int i = 0; i < n; i++) {
        cnt[a[i]]--;
        if (j == 0) {
          res[j++] = a[i];
          seen[a[i]] = true;
        } else {
          if (seen[a[i]]) {
            continue;
          }
          while (j > 0 && cnt[res[j - 1]] > 0 && optimize(a[i], j - 1, res)
              || j >= 2 && cnt[res[j - 1]] > 0 && cnt[res[j - 2]] > 0 && optimize(j - 2, a[i], res)) {
            if (j > 0 && cnt[res[j - 1]] > 0 && optimize(j - 1, a[i], res)) {
              seen[res[j - 1]] = false;
              j--;
            } else {
              if (j >= 1) {
                seen[res[j - 1]] = false;
                j--;
              }
              if (j >= 1) {
                seen[res[j - 1]] = false;
                j--;
              }
            }
          }
          res[j++] = a[i];
          seen[a[i]] = true;
        }
      }
      System.out.println(j);
      for (int i = 0; i < j; i++) {
        System.out.print(res[i] + " ");
      }
      System.out.println();
    }
  }
}
