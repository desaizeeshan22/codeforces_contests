package codeforces_961_div2;

import java.util.Scanner;

public class problemC {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int tests = sc.nextInt();
    while (tests-- > 0) {
      int n = sc.nextInt();
      long[] arr = new long[n];
      for (int i = 0; i < n; i++) {
        arr[i] = sc.nextLong();
      }
      long res = 0, last = 0;
      for (int i = 1; i < n; i++) {
        long c1 = 0l, c2 = 0l;
        long temp = arr[i - 1];
        long temp2 = arr[i];
        if (temp2 == 1l && temp > 1l) {
          res = -1l;
          break;
        }
        while (temp2 < temp) {
          temp2 = temp2 * temp2;
          c2++;
        }
        while (temp * temp <= temp2) {
          if (temp == 1l) {
            c1 = -1l;
            break;
          }
          c1++;
          temp *= temp;
        }
        if (c2 > 0l) {
          last += c2;
        } else if (c1 == -1l) {
          last = 0l;
        } else {
          last = Math.max(0l, last - c1);
        }
        res += last;
      }
      System.out.println(res);
    }
  }
}
