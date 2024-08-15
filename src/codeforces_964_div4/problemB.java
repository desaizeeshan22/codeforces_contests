package codeforces_964_div4;

import java.util.Scanner;

public class problemB {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int tests = sc.nextInt();
    while (tests-- > 0) {
      int[] a = new int[2], b = new int[2];
      int a1 = sc.nextInt();
      a[0] = a1;
      int a2 = sc.nextInt();
      a[1] = a2;
      int b1 = sc.nextInt();
      b[0] = b1;
      int b2 = sc.nextInt();
      b[1] = b2;
      int[][] r = new int[4][4];
      int k = 0;
      for (int i = 0; i < 2; i++) {
        r[k++] = new int[] {a[i], b[i], a[1 - i], b[1 - i]};
        r[k++] = new int[] {a[i], b[1 - i], a[1 - i], b[i]};
      }
      int res = 0;
      for (int i = 0; i < k; i++) {
        int su = 0, sl = 0;
        if (r[i][0] > r[i][1]) {
          su++;
        } else if (r[i][0] < r[i][1]) {
          sl++;
        }
        if (r[i][2] > r[i][3]) {
          su++;
        } else if (r[i][2] < r[i][3]) {
          sl++;
        }
        if (su > sl) {
          res++;
        }
      }

      System.out.println(res);
    }
  }
}
