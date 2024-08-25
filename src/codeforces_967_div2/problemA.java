package codeforces_967_div2;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class problemA {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int tests = sc.nextInt();
    while (tests-- > 0) {
      int n = sc.nextInt();
      Map<Integer, Integer> mp = new TreeMap<>();
      for (int i = 0; i < n; i++) {
        int temp = sc.nextInt();
        mp.put(temp, mp.getOrDefault(temp, 0) + 1);
      }
      if (n == 1) {
        System.out.println(0);
        continue;
      }
      int maxCount = 0;
      for (int k : mp.keySet()) {
        maxCount = Math.max(maxCount, mp.get(k));
      }
      System.out.println(n - maxCount);
    }
  }
}
