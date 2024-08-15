package epic_div1_div2_august_2024;

import java.util.Scanner;

public class problemB {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int tests = sc.nextInt();
    while (tests-- > 0) {
      int n = sc.nextInt();
      int[] a = new int[n];
      int[] b = new int[n];

      int numEq = 0;
      for (int i = 0; i < n; i++) {
        a[i] = sc.nextInt();
      }
      for (int i = 0; i < n; i++) {
        b[i] = sc.nextInt();
        numEq += (a[i] == b[i] ? 1 : 0);
      }
      reverse(b);
      if (numEq == n || is_equal(a, b)) {
        System.out.println("Bob");
      } else {
        System.out.println("Alice");
      }
    }
  }

  public static void reverse(int[] arr) {
    int i = 0, j = arr.length - 1;
    while (i <= j) {
      int temp = arr[i];
      arr[i] = arr[j];
      arr[j] = temp;
      i++;
      j--;
    }
  }

  public static boolean is_equal(int[] a, int[] b) {
    for (int i = 0; i < a.length; i++) {
      if (a[i] != b[i]) {
        return false;
      }
    }
    return true;
  }
}
