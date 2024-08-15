package codeforces_963_div2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class problemB {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int tests = sc.nextInt();
    while (tests-- > 0) {
      long max_even = 0, max_odd = 0;
      List<Long> even_nums = new ArrayList<>();
      int n = sc.nextInt();
      for (int i = 0; i < n; i++) {
        long temp = sc.nextLong();
        if ((temp & 1) == 0) {
          max_even = Math.max(max_even, temp);
          even_nums.add(temp);
        } else {
          max_odd = Math.max(max_odd, temp);
        }
      }
      if (even_nums.size() == n || even_nums.size() == 0) {
        System.out.println(0);
        continue;
      }
      long res = even_nums.size();
      Collections.sort(even_nums);
      for (Long elem : even_nums) {
        if (elem < max_odd) {
          max_odd += elem;
        } else {
          res++;
          break;
        }
      }
      System.out.println(res);
    }
  }
}
