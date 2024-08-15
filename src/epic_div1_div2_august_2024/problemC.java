package epic_div1_div2_august_2024;

import java.util.Scanner;

public class problemC {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int tests = sc.nextInt();
    while (tests-- > 0) {
      int n = sc.nextInt();
      long[][] interPoints = new long[n][2];
      for (int i = 0; i < n; i++) {
        long[] temp = new long[2];
        temp[0] = sc.nextLong();
        temp[1] = sc.nextLong();
        interPoints[i] = temp;
      }
      long[] src = new long[2], dest = new long[2];
      src[0] = sc.nextLong();
      src[1] = sc.nextLong();
      dest[0] = sc.nextLong();
      dest[1] = sc.nextLong();
      long s_dest = euclideanDistance(src, dest);
      String isPossible = "YES";
      long minDistance = Long.MAX_VALUE;
      for (int i = 0; i < n; i++) {
        minDistance = Math.min(minDistance, euclideanDistance(dest, interPoints[i]));
      }
      if (minDistance <= s_dest) {
        isPossible = "NO";
      }
      System.out.println(isPossible);

    }
  }

  public static long euclideanDistance(long[] a, long[] b) {
    return (a[0] - b[0]) * (a[0] - b[0]) + (a[1] - b[1]) * (a[1] - b[1]);
  }
}
