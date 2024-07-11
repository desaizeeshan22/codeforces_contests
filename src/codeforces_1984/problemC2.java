package codeforces_1984;

import java.util.Scanner;

public class problemC2 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    long t = sc.nextInt();
    for (long tcase = 0; tcase < t; tcase++) {
      int n = sc.nextInt();


      long[] arr = new long[n];
      for (int i = 0; i < n; i++) {
        arr[i] = sc.nextInt();
      }

//      System.out.println(solution(arr, n));
    }
  }

//  public static long solution(long[] arr, int n) {
//    int[] miniIndices = new int[n];
//    int j = 0;
//    long mini = Long.MAX_VALUE;
//    long running_sum = 0;
//    for (long elem : arr) {
//      running_sum += elem;
//      mini = Math.min(mini, running_sum);
//    }
//    for (int l = 0; l < n; l++) {
//      if (arr[l] == mini) {
//        miniIndices[j++] = l;
//      }
//    }
//    running_sum = 0;
//    int num_indices = 0;
//    for (long elem : arr) {
//      running_sum += elem;
//      if (running_sum >= 0) {
//        num_indices++;
//      }
//    }
//  }
}
