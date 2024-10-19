package codeforces_978_div_2;

import java.util.*;

public class problemA {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int tests = sc.nextInt();
    while (tests-- > 0) {
      int n = sc.nextInt();
      int r = sc.nextInt();
      int rows = 0;
      int people = 0;
      int happy = 0;
      List<Map.Entry<Integer, Integer>> s = new LinkedList<>();
      for (int i = 0; i < n; i++) {
        s.add(Map.entry(i, sc.nextInt()));
      }
      Collections.sort(s, (a, b) -> (b.getValue() - a.getValue()));
      for (int i = 0; i < n; i++) {
        Map.Entry<Integer, Integer> entry = s.get(i);
        int occupied = entry.getValue() / 2;
        rows += occupied;
        int updatedSeats = entry.getValue() - (occupied * 2);
        s.set(i, Map.entry(entry.getKey(), updatedSeats));
        if (updatedSeats > 0) {
          people++;
        }
      }
      happy += (rows * 2);
      int remainingRows = r - rows;
      if (remainingRows >= people) {
        happy += people;
      } else {
        happy += (2 * remainingRows - people);

      }
      System.out.println(happy);
    }
  }
}
