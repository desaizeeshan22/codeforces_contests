package codeforces_953_div_2;

import java.util.Scanner;

public class problemD {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int tests = sc.nextInt();
    for (int t = 0; t < tests; t++) {
      int n = sc.nextInt();
      long c = sc.nextLong();
      long[] arr = new long[n];
      long[] sum_arr = new long[n];
      long maxi = Long.MIN_VALUE, maxIndex = 0, running_sum = 0;
      for (int i = 0; i < n; i++) {
        arr[i] = sc.nextLong();
        running_sum += arr[i];
        sum_arr[i] = running_sum;
        if (arr[i] > maxi) {
          maxIndex = i;
          maxi = arr[i];
        }
      }
      int[] res = new int[n];
      if (arr[0] + c >= maxi) {
        res[0] = 0;
      } else {
        res[0] = 1;
      }
      for (int j = 1; j < n; j++) {
        if (j == maxIndex && arr[j] == maxi && arr[0] + c < arr[j]) {
          res[j] = 0;
        } else if (sum_arr[j - 1] + c + arr[j] >= maxi) {
          res[j] = j;
        } else {
          res[j] = j + 1;
        }
      }
      for (int elem : res) {
        System.out.print(elem);
        System.out.print(" ");
      }
      System.out.println("");
    }
  }
}
