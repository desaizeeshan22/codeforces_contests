package codeforces_1984;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import static java.lang.Long.MAX_VALUE;
import static java.lang.Long.MIN_VALUE;

public class problemA {
  public static Map<String, List<Integer>> resMp;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    for (int tcase = 0; tcase < t; tcase++) {
      int n = sc.nextInt();
      int[] arr = new int[n];
      for (int j = 0; j < n; j++) {
        arr[j] = sc.nextInt();
      }
      if (arr[0] == arr[n - 1]) {
        System.out.println("NO");
      } else {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
          sb.append('R');
        }
        sb.setCharAt(1, 'B');
        System.out.println("YES");
        System.out.println(sb);
      }
    }
  }

  public static StringBuilder generate(int[] arr) {
    StringBuilder res = new StringBuilder();
    for (int i = 0; i < arr.length; i++) {
      long mx = MIN_VALUE, mn = MAX_VALUE;
      for (int j = 0; j < arr.length; j++) {
        if (i != j) {
          mx = Math.max(mx, arr[j]);
          mn = Math.min(arr[j], mn);
        }
      }
      if (mx != mn) {
        for (int k = 0; k < arr.length; k++) {
          res.append(i == k ? "R" : "B");
        }
        return res;
      }
    }
    return res;
  }
}

