package Pinely_round_4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class problemC {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int tests = sc.nextInt();
    while (tests-- > 0) {
      int n = sc.nextInt();
      int[] arr = new int[n];
      List<Integer> ops = new ArrayList<>();
      for (int i = 0; i < n; i++) {
        arr[i] = sc.nextInt();
      }
      for (int i = 0; i < 40; i++) {
        int zeros = 0;
        for (int j = 0; j < n; j++) {
          if (arr[j] == 0) {
            zeros++;
          }
        }
        if (zeros == n) {
          break;
        }
        int maxElem = Arrays.stream(arr).max().getAsInt();
        int minElem = Arrays.stream(arr).min().getAsInt();
        int diff = (maxElem + minElem) / 2;
        ops.add(diff);
        for (int j = 0; j < n; j++) {
          arr[j] = Math.abs(arr[j] - diff);
        }

      }
      int res = 0;
      for (int i = 0; i < n; i++) {
        if (arr[i] != 0) {
          res = -1;
          break;
        }
      }
      if (res == -1) {
        System.out.print(res);
      } else {
        System.out.print(ops.size());
        System.out.println();
        for (int elem : ops) {
          System.out.print(elem);
          System.out.print(" ");
        }
      }
      System.out.println();
    }
  }
}
