package codeforces_954_div3;

import java.util.Scanner;

public class problemD {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int tests = sc.nextInt();
    for (int t = 0; t < tests; t++) {
      int n = sc.nextInt();
      String s = sc.next();
      char[] arr = s.toCharArray();
      int[] nums = new int[n];
      int ans = Integer.MAX_VALUE;
      for (int i = 0; i < n - 1; i++) {
        int j = 0;
        for (int k = 0; k < n; k++) {
          if (i == k) {
            nums[j++] = (10 * (arr[k] - '0') + (arr[k + 1] - '0'));
            k++;
          } else {
            nums[j++] = arr[k] - '0';
          }
        }
        int val = 0;
        for (int a = 0; a < j; a++) {
          if (nums[a] == 0) {
            val = -1;
            break;
          }
          if (nums[a] == 1) {
            continue;
          }
          val += nums[a];
        }
        if (val == 0) {
          val = 1;
        }
        if (val == -1) {
          val = 0;
        }
        ans = Math.min(ans, val);
      }
      System.out.println(ans);
    }
  }
}
