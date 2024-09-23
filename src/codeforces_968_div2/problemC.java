package codeforces_968_div2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class problemC {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int tests = sc.nextInt();
    while (tests-- > 0) {
      int n = sc.nextInt();
      char[] s = sc.next().toCharArray();
      Map<Character, Integer> mp = new HashMap<>();
      for (char c : s) {
        mp.put(c, mp.getOrDefault(c, 0) + 1);
      }
      StringBuilder res = new StringBuilder();
      while (true) {
        int temp = 0;
        for (char k : mp.keySet()) {
          if (mp.getOrDefault(k, 0) > 0) {
            res.append(k);
            temp += mp.getOrDefault(k, 0);
            mp.put(k, mp.getOrDefault(k, 0) - 1);
          }
        }
        if (temp == 0) {
          break;
        }
      }
      System.out.println(res);
    }
  }
}

