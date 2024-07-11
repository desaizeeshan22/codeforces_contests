package codeforces_1984;

import java.util.Scanner;

public class problemC1 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    long t = sc.nextInt();
    for (long tcase = 0; tcase < t; tcase++) {
      int n = sc.nextInt();


      long[] arr = new long[n];
      for (int i = 0; i < n; i++) {
        arr[i] = sc.nextInt();
      }
      long running = 0;
      long maxi = 0;
      for (long elem : arr) {
        running += elem;
        maxi += elem;
        maxi = Math.max(maxi, Math.abs(running));
      }
      System.out.println(alternateSolution(arr, n));
    }

  }

  public static long alternateSolution(long[] arr, int n) {
    //    track the prefix sum minmum throghout the array
    //    Only use option 2 once the prefix minimum is reached aka at the prefix mimum index
    //    Option 1: c= c+a[i]
    //    Option 2: c=abs(c+a[i])
    long prefix_mn = Long.MAX_VALUE;
    int mn_index = 0;
    long running_sum = 0;
    for (int i = 0; i < n; i++) {
      running_sum += arr[i];
      if (running_sum < prefix_mn) {
        prefix_mn = running_sum;
        mn_index = i;
      }
    }
    running_sum = 0;
    for (int i = 0; i < n; i++) {
      running_sum += arr[i];
      if (i == mn_index) {
        running_sum = Math.abs(running_sum);
      }
    }
    return running_sum;
  }
}
