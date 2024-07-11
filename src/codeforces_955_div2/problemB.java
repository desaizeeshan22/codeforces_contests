package codeforces_955_div2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class problemB {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int tests = sc.nextInt();
    for (int t = 0; t < tests; t++) {
      long x = sc.nextLong();
      long y = sc.nextLong();
      long k = sc.nextLong();
      List<Long> num = new ArrayList<>();
      while (x != 0) {
        num.add(x % y);
        x = x / y;
      }
      long res = 0;
      for (int i = 0; i < num.size(); i++) {
        long temp = y - num.get(i);
        if (k >= temp) {
          k -= temp;
          if (i < num.size() - 1) {
            num.set(i + 1, num.get(i + 1) + 1);
          }
        } else {
          num.set(i, num.get(i) + k);
          for (int j = num.size() - 1; j >= i; j--) {
            res = res * y + num.get(j);
          }
          break;
        }
        if (i == num.size() - 1) {
          res = (1 + (k % (y - 1)));
        }
      }

      System.out.println(res);
    }
  }
}
