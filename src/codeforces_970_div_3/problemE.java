package codeforces_970_div_3;

import java.util.Arrays;
import java.util.Scanner;

public class problemE {


  public static void main(String[] arg) {
    Scanner sc = new Scanner(System.in);
    int tests = sc.nextInt();
    while (tests-- > 0) {
      int n = sc.nextInt();
      char[] s = sc.next().toCharArray();
      if ((n & 1) == 0) {
        int[] evenCount = new int[26];
        int[] oddCount = new int[26];
        for (int i = 0; i < n; i++) {
          if ((i & 1) == 1) {
            oddCount[s[i] - 'a']++;
          } else {
            evenCount[s[i] - 'a']++;
          }
        }
        int mxOdd = Arrays.stream(oddCount).max().getAsInt();
        int mxEven = Arrays.stream(evenCount).max().getAsInt();
        int ans = n - mxEven - mxOdd;
        System.out.println(ans);
      } else {
        int[] evenCount = new int[26];
        int[] oddCount = new int[26];
        int[] beforeEvenCount = new int[26];
        int[] beforeOddCount = new int[26];
        int ans = (int) 1e9;
        for (int i = 0; i < n; i++) {
          if ((i & 1) == 1) {
            oddCount[s[i] - 'a']++;
          } else {
            evenCount[s[i] - 'a']++;
          }
        }
        for (int removed = 0; removed < n; removed++) {
          if ((removed & 1) == 1) {
            oddCount[s[removed] - 'a']--;
          } else {
            evenCount[s[removed] - 'a']--;
          }
          int mxEven = 0, mxOdd = 0;
          for (int i = 0; i < 26; i++) {
            mxEven = Math.max(beforeEvenCount[i] + oddCount[i], mxEven);
          }
          for (int i = 0; i < 26; i++) {
            mxOdd = Math.max(beforeOddCount[i] + evenCount[i], mxOdd);
          }
          ans = Math.min(ans, n - mxEven - mxOdd);
          if ((removed & 1) == 1) {
            beforeOddCount[s[removed] - 'a']++;
          } else {
            beforeEvenCount[s[removed] - 'a']++;
          }
        }
        System.out.println(ans);
      }
    }
  }


}
