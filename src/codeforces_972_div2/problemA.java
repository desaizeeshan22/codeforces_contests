package codeforces_972_div2;

import java.util.Arrays;
import java.util.Scanner;

public class problemA {
  public static char[] vowels = new char[] {'a', 'e', 'i', 'o', 'u'};

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int tests = sc.nextInt();
    while (tests-- > 0) {
      int n = sc.nextInt();
      int j = 0;
      String res = "";
      while (j < n) {
        res += (vowels[j % 5]);
        j++;
      }
      char[] arr = res.toCharArray();
      Arrays.sort(arr);
      System.out.println(new String(arr));
    }
  }
}
