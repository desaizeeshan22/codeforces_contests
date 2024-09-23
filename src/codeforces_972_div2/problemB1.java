package codeforces_972_div2;

import java.util.Arrays;
import java.util.Scanner;

public class problemB1 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int tests = sc.nextInt();
    while (tests-- > 0) {
      int n = sc.nextInt();
      int m = sc.nextInt();
      int q = sc.nextInt();
      int[] dist = new int[2];
      dist[0] = sc.nextInt();
      dist[1] = sc.nextInt();
      int d = sc.nextInt();
      Arrays.sort(dist);
      if (d < dist[0]) {
        System.out.println(dist[0] - 1);
        continue;
      }
      if (d > dist[1]) {
        System.out.println(n - dist[1]);
        continue;
      }
      int mid = (dist[0] + dist[1]) >> 1;
      System.out.println(Math.min(Math.abs(dist[0] - mid), Math.abs(dist[1] - mid)));
    }
  }
}
