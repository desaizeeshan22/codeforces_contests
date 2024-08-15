package codeforces_edu_168_div2;

import java.util.Scanner;
import java.util.Stack;

public class problemC {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int tests = sc.nextInt();
    while (tests-- > 0) {
      int n = sc.nextInt();
      StringBuilder s = new StringBuilder(sc.next());
      for (int i = 0; i < s.length(); i++) {
        if (i == 0 || s.charAt(i - 1) == ')') {
          s.setCharAt(i, '(');
        }
      }
      System.out.println(mini(s));
    }
  }

  public static int mini(StringBuilder s) {
    int res = 0;
    Stack<Integer> st = new Stack<>();
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '(') {
        st.add(i);
      } else if (!st.empty()) {
        res += (i - st.pop());
      }
    }
    return res;
  }
}
