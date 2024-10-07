package codeforces_977_div_2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class problemB {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int tests = sc.nextInt();
    while (tests-- > 0) {
      int n = sc.nextInt();
      int x = sc.nextInt();
      Map<Integer, Integer> mp = new HashMap<>();
      int[] arr = new int[n];
      int mex = 0;
      for (int i = 0; i < n; i++) {
        arr[i] = sc.nextInt();
        mp.put(arr[i], mp.getOrDefault(arr[i], 0) + 1);
      }
      for (int i = 0; i <= n; i++) {
        if (mp.getOrDefault(i, 0) > 0) {
          mp.put(i, mp.getOrDefault(i, 0) - 1);
          mp.put(i + x, mp.getOrDefault(i, 0) + mp.getOrDefault(i + x, 0));
          //        } else if (mp2.getOrDefault(i % x, 0) > 0) {
          //          mp2.put(i % x, mp.getOrDefault(i % x, 0) - 1);
        } else {
          mex = i;
          break;
        }
      }
      System.out.println(mex);
    }
  }
}
