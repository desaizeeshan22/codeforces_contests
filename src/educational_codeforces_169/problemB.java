package educational_codeforces_169;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class problemB {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int tests = sc.nextInt();
    while (tests-- > 0) {
      List<int[]> intervals = new ArrayList<>();
      for (int i = 0; i < 2; i++) {
        int[] temp = new int[2];
        temp[0] = sc.nextInt();
        temp[1] = sc.nextInt();
        intervals.add(temp);
      }
      Collections.sort(intervals, (a, b) -> (a[0] - b[0]));
      if (intervals.get(0)[0] == intervals.get(1)[0] && intervals.get(1)[1] == intervals.get(0)[1]) {
        System.out.println(intervals.get(0)[1] - intervals.get(0)[0]);
        continue;
      }
      if (intervals.get(1)[0] > intervals.get(0)[1]) {
        System.out.println(1);
        continue;
      }
      int[] overlap = new int[2];
      overlap[0] = intervals.get(1)[0];
      overlap[1] = Math.min(intervals.get(1)[1], intervals.get(0)[1]);
      int temp = overlap[1] - overlap[0];
      if (overlap[0] - 1 >= intervals.get(0)[0] || overlap[0] - 1 >= intervals.get(1)[0]) {
        temp++;
      }
      if (overlap[1] + 1 <= intervals.get(0)[1] || overlap[1] + 1 <= intervals.get(1)[1]) {
        temp++;
      }
      System.out.println(temp);
    }
  }
}
