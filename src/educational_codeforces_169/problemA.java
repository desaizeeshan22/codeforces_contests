package educational_codeforces_169;

import java.util.Arrays;
import java.util.Scanner;

public class problemA {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int tests = sc.nextInt();
    while (tests-- > 0) {
      int n = sc.nextInt();
      int[] a = new int[n];

      for (int i = 0; i < n; i++) {
        a[i] = sc.nextInt();
      }
      Arrays.sort(a);
      int distAv = 0, minDistance = 101;
      for (int i = 1; i < n; i++) {
        int absDist = Math.abs(a[i] - a[i - 1]);
        minDistance = Math.min(minDistance, absDist);
        distAv += absDist;
      }
      if (n > 2) {
        System.out.println("NO");
      } else {
        if (minDistance == 1) {
          System.out.println("NO");
        } else {
          System.out.println("YES");
        }
      }
    }
  }

  public static boolean contains(int[] arr, int elem) {
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == elem) {
        return true;
      }
    }
    return false;
  }
}
