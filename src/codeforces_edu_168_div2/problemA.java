package codeforces_edu_168_div2;

import java.util.Scanner;

public class problemA {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int tests = sc.nextInt();
    while (tests-- > 0) {
      StringBuilder s = new StringBuilder(sc.next());
      StringBuilder res = new StringBuilder();
      if (s.length() == 1) {
        res.append(s.charAt(0));
        for (int i = 0; i < 26; i++) {
          if (s.charAt(0) != ('a' + i)) {
            res.append(Character.toString('a' + i));
            break;
          }
        }
        System.out.println(res);
        continue;
      }
      int idx = 0;
      char c = 'a';
      for (int i = 1; i < s.length(); i++) {
        if (s.charAt(i) == s.charAt(i - 1)) {
          idx = i;
          c = s.charAt(i);
          break;
        }
      }
      for (int i = 0; i < idx; i++) {
        res.append(s.charAt(i));
      }
      for (int j = 0; j < 26; j++) {
        if (s.charAt(idx) != ('a' + j)) {
          res.append(Character.toString('a' + j));
          break;
        }
      }
      for (int i = idx; i < s.length(); i++) {
        res.append(s.charAt(i));
      }
      System.out.println(res);
    }
  }
}
