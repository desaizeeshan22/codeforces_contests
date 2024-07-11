package codeforces_173;

import java.util.Scanner;

public class problemD {
  public static int n;
  public static int minElem = Integer.MAX_VALUE;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    int[] arr = new int[n];
    for (int k = 0; k < n; k++) {
      arr[k] = sc.nextInt();
      minElem = Math.min(arr[k], minElem);
    }
    if (n >= 2) {
      if (lgmWins(0, 1, arr) || lgmWins(0, 2, arr)) {
        System.out.println("BitLGM");
      } else {
        System.out.println("BitAryo");
      }
    } else if (n == 1) {
      if (arr[0] == 0) {
        System.out.println("BitAryo");
      } else {
        System.out.println("BitLGM");
      }
    }
  }

  public static boolean lgmWins(int i, int move, int[] arr) {
    if (arr[i] <= 0) {
      return i % 2 != 0;
    }
    boolean res = false;
    if (move == 1) {
      for (int x = 1; x <= arr[i]; x++) {
        arr[i] -= x;
        res = res || lgmWins((i + 1) % n, 1, arr);
        res = res || lgmWins((i + 1) % n, 2, arr);
        arr[i] += x;
      }
    } else {
      for (int x = 1; x <= minElem; x++) {
        for (int j = 0; j < n; j++) {
          arr[j] -= x;
        }
        res = res || lgmWins((i + 1) % n, 1, arr);
        res = res || lgmWins((i + 1) % n, 2, arr);
        for (int j = 0; j < n; j++) {
          arr[j] += x;
        }
      }
    }
    return res;
  }
}
