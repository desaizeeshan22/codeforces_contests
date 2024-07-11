package codeforces_1984;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class problemB {


  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    long t = sc.nextInt();
    for (long tcase = 0; tcase < t; tcase++) {
      long n = sc.nextLong();
      List<Long> l = new ArrayList<>();
      while (n > 0) {
        l.add(n % 10);
        n /= 10;
      }
      boolean flag = true;
      if (l.get(l.size() - 1) != 1) {
        flag = false;
      } else {
        for (int i = 0; i < l.size() - 1; i++) {
          if ((i == 0 && l.get(i) == 9) || i != 0 && l.get(i) == 0) {
            flag = false;
            break;
          }
        }
      }
      if (flag) {
        System.out.println("YES");
      } else {
        System.out.println("NO");
      }
    }
  }
}

