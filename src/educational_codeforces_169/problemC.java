package educational_codeforces_169;

import java.util.Arrays;
import java.util.Scanner;

public class problemC {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int tests = sc.nextInt();
    while (tests-- > 0) {
      int n = sc.nextInt();
      long k = sc.nextLong();
      long[] arr = new long[n];
      for (int i = 0; i < n; i++) {
        long temp = sc.nextLong();
        arr[i] = temp;
      }
      Arrays.sort(arr);
      reverse(arr);
      long A = 0, B = 0;
      for (int i = 1; i < n; i++) {
        if ((i & 1) == 0) {
          continue;
        }
        if (k >= 0) {
          long temp = Math.min(arr[i - 1] - arr[i], k);
          k -= temp;
          arr[i] += temp;
        }
      }
      for (int i = 0; i < n; i++) {
        if ((i & 1) == 0) {
          A += arr[i];
        } else {
          B += arr[i];
        }
      }
      System.out.println(A - B);
    }
  }

  public static void reverse(long[] arr) {
    int i = 0, j = arr.length - 1;
    while (i <= j) {
      long temp = arr[i];
      arr[i] = arr[j];
      arr[j] = temp;
      i++;
      j--;
    }
  }
}
