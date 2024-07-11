package codeforces_953_div_2;

import java.util.Scanner;

import static java.lang.Math.abs;

public class problemC {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int cases = sc.nextInt();
    for (int t = 0; t < cases; t++) {
      int n = sc.nextInt();
      long k = sc.nextLong();
      int[] arr = new int[n];
      for (int i = 1; i <= n; i++) {
        arr[i - 1] = i;
      }
      if ((k & 1) == 1) {
        System.out.println("No");
      } else {
        int j = n - 1;
        int i = 0;
        while (i <= j) {
          long temp = 2 * abs(arr[j] - arr[i]);
          if (k <= 0) {
            break;
          }
          if (temp <= k) {
            swap(arr, i, j);
            j -= 1;
            i += 1;
            k -= temp;
          } else {
            j -= 1;
          }
        }
        if (k != 0) {
          System.out.println("No");
        } else {
          System.out.println("Yes");
          for (int elem : arr) {
            System.out.print(elem);
            System.out.print(" ");
          }
          System.out.println("");
        }
      }
    }
  }

  public static void swap(int[] arr, int a, int b) {
    int temp = arr[a];
    arr[a] = arr[b];
    arr[b] = temp;
  }
}
