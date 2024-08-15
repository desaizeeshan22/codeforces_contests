package codeforces_964_div4;

import java.util.Scanner;

public class problemE {
  public static int res;
  public static int[] prefix;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    populatePrefix();
    int tests = sc.nextInt();
    while (tests-- > 0) {
      int l = sc.nextInt();
      int r = sc.nextInt();
      System.out.println(prefix[r] - prefix[l - 1] + numDiv(l));
    }
  }


  public static int numDiv(int num) {
    int res = 0;
    while (num > 0) {
      res++;
      num /= 3;
    }
    return res;
  }

  public static void populatePrefix() {
    prefix = new int[200001];
    for (int i = 1; i <= 200000; i++) {
      prefix[i] = prefix[i - 1] + numDiv(i);
    }
  }
}
