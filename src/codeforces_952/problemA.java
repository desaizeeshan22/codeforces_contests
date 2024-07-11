package codeforces_952;

import java.util.Scanner;

public class problemA {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    for (int test = 0; test < T; test++) {
      int n = sc.nextInt();
      int[] arr = new int[n];
      for (int j = 0; j < n; j++) {
        arr[j] = sc.nextInt();
      }
      System.out.println(solution(arr, n));
    }
  }

  public static int solution(int[] arr, int n) {
    int minElem = Integer.MAX_VALUE;
    for (int i = 0; i < n - 1; i++) {
      minElem = Math.min(minElem, Math.max(arr[i], arr[i + 1]));
    }
    return minElem - 1;
  }
}
