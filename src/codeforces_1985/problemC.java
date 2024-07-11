package codeforces_1985;

import java.util.Scanner;

//The only element that can be the sum of all other elements is the maximum element, since all elements are positive. Therefore, for each prefix i
//    from 1
//    to n
//    , check if sum(a1,a2,...,ai)−max(a1,a2,...,ai)=max(a1,a2,...,ai)
//    . The sum and max of prefixes can be tracked with variables outside the loop.
public class problemC {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int test = sc.nextInt();
    for (int c = 0; c < test; c++) {
      int n = sc.nextInt();
      long[] arr = new long[n];
      long currMax = Integer.MIN_VALUE;
      long rSum = 0;
      long res = 0;
      for (int i = 0; i < n; i++) {
        arr[i] = sc.nextLong();
        rSum += arr[i];
        currMax = Math.max(arr[i], currMax);
        if (rSum - currMax == currMax) {
          res++;
        }
      }
      System.out.println(res);
    }
  }
}
