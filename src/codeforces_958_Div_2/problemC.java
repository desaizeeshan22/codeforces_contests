package codeforces_958_Div_2;

import java.util.Scanner;

public class problemC {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    long lines = sc.nextLong();
    while (lines-- > 0) {
      long n = sc.nextLong();
      int bitCount = 0;
      long tem = n;
      while (tem != 0) {
        bitCount += (tem & 1);
        tem = tem >> 1;
      }
      if (bitCount == 1) {
        System.out.println(bitCount);
        System.out.println(n);
        continue;
      }
      bitCount++;
      System.out.print(bitCount);
      System.out.println();
      for (int i = 0; i < bitCount; i++) {
        long temp = 0;
        int toggle = 0;
        int cnt = 0;
        for (long j = 62; j >= 0; j--) {
          if ((n & (1l << j)) != 0) {
            cnt++;
            if (cnt <= i) {
              temp += (1l << j);
            } else {
              if (toggle == 1) {
                temp += (1l << j);
              }
              toggle = 1 - toggle;
            }
          }
        }
        System.out.print(temp);
        System.out.print(" ");
      }
      System.out.println();
    }

  }
}
