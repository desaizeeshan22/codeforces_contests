package codeforces_964_div4;

import java.util.Scanner;

public class problemD {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int tests = sc.nextInt();
    while (tests-- > 0) {
      StringBuilder s = new StringBuilder(sc.next());
      StringBuilder t = new StringBuilder(sc.next());
      int j = 0, i = 0;
      while (i < s.length()) {
        if (j >= t.length()) {
          break;
        }
        if (s.charAt(i) == '?') {
          s.setCharAt(i, t.charAt(j));
          j++;
        } else {
          if (s.charAt(i) == t.charAt(j)) {
            j++;
          }
        }
        i++;
      }
      String res = j >= t.length() ? "YES" : "NO";
      for (int k = 0; k < s.length(); k++) {
        if (s.charAt(k) == '?') {
          s.setCharAt(k, 'z');
        }
      }
      System.out.println(res);
      if (res == "YES") {
        System.out.println(s);
      }
    }
  }
}
