package epic_div1_div2_august_2024;

import java.util.Scanner;

public class problemD1 {


  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int tests = sc.nextInt();
    while (tests-- > 0) {
      int n = sc.nextInt();
      int q = sc.nextInt();
      int[] parents = new int[n + 1];
      int[] positions = new int[n + 1];
      int[] perm = new int[n + 1];
      for (int i = 1; i < n; i++) {
        parents[i + 1] = sc.nextInt();

      }
      for (int i = 1; i <= n; i++) {
        perm[i] = sc.nextInt();
        positions[perm[i]] = i;
      }
      
    }
  }

  public static void swap(int i, int j, int[] arr) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  public static boolean isValid(int[] parents, int[] positions, int n) {
    for (int i = 1; i <= n; i++) {
      if (positions[parents[i]] > positions[i]) {
        return false;
      }
    }
    return true;
  }
}
