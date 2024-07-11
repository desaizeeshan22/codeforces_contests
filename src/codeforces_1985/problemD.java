package codeforces_1985;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class problemD {
  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    for (int i = 0; i < n; i++) {
      int r = sc.nextInt();
      int c = sc.nextInt();
      List<String> grid = new ArrayList<>();
      for (int l = 0; l < r; l++) {
        grid.add(sc.next());
      }
      int[] upperPoint = new int[] {Integer.MAX_VALUE, Integer.MAX_VALUE}, lowerPoint = new int[] {-1, -1}, leftPoint =
          new int[] {Integer.MAX_VALUE, Integer.MAX_VALUE}, rightPoint =
          new int[] {-1, -1};
      for (int row = 0; row < r; row++) {
        for (int col = 0; col < c; col++) {
          if (grid.get(row).charAt(col) == '#') {
            if (row < upperPoint[0]) {
              upperPoint[0] = row;
              upperPoint[1] = col;
            }
            if (row > lowerPoint[0]) {
              lowerPoint[0] = row;
              lowerPoint[1] = col;
            }
            if (col < leftPoint[1]) {
              leftPoint[0] = row;
              leftPoint[1] = col;
            }
            if (col >= rightPoint[1]) {
              rightPoint[0] = row;
              rightPoint[1] = col;
            }
          }
        }
      }
      List<Integer> res = new ArrayList<>();
      res.add(((upperPoint[0] + lowerPoint[0]) / 2) + 1);
      res.add(((leftPoint[1] + rightPoint[1]) / 2) + 1);
      System.out.print(res.get(0));
      System.out.print(" ");
      System.out.print(res.get(1));
      System.out.println();
    }
  }
}
