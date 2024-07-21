package codeforces_958_Div_2;

import java.util.Scanner;

public class problemB {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int lines = sc.nextInt();
    while (lines-- > 0) {
      int n = sc.nextInt();
      String s = sc.next();
      long[] arr = new long[n];
      for (int i = 0; i < n; i++) {
        arr[i] = s.charAt(i) - '0';
      }
      long prev = 1;
      int c_0 = 0, c_1 = 0;
      for (int i = 0; i < arr.length; i++) {
        if (arr[i] == 0 && prev == 1) {
          c_0++;
        } else if (arr[i] == 1) {
          c_1++;
        }
        prev = arr[i];
      }
      if (c_0 >= c_1) {
        System.out.println("No");
      } else {
        System.out.println("Yes");
      }
    }
  }
}
