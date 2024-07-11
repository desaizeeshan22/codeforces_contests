package codeforces_173;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class problemA {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Map<String, Integer> mp = new HashMap<>();
    mp.put("X++", 1);
    mp.put("++X", 1);
    mp.put("--X", -1);
    mp.put("X--", -1);
    int n = sc.nextInt();
    int res = 0;
    for (int i = 0; i < n; i++) {
      String expression = sc.next();
      res += (mp.get(expression));
    }
    System.out.println(res);
  }
}
