package codeforces_957_div3;

import java.util.Arrays;
import java.util.Scanner;

public class problemA {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t-- > 0) {
      int a = sc.nextInt();
      int b = sc.nextInt();
      int c = sc.nextInt();
      int[] nums = new int[] {a, b, c};
      Arrays.sort(nums);
      int res = 0;
      for (int i = 0; i < 6; i++) {
        for (int j = 0; j < 6 - i; j++) {
          int nA = nums[0] + i;
          int nB = nums[1] + j;
          int nC = nums[2] + (5 - i - j);
          res = Math.max(res, nA * nB * nC);
        }
      }
      System.out.println(res);
    }
  }
}
