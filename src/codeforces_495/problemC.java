package codeforces_495;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class problemC {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    long r = sc.nextLong();
    long avg = sc.nextLong();
    long required_total = avg * n;
    long curr_total = 0;
    List<Map.Entry<Long, Long>> l = new LinkedList<>();
    for (int i = 0; i < n; i++) {
      l.add(Map.entry(sc.nextLong(), sc.nextLong()));
      curr_total += l.get(i).getKey();
    }
    if (curr_total >= required_total) {
      System.out.println(0);
    } else {
      l.sort(Map.Entry.comparingByValue());
      long required_pts = required_total - curr_total;
      long res = 0;
      for (Map.Entry<Long, Long> elem : l) {

        long avail_increase = r - elem.getKey();
        if (avail_increase >= required_pts) {
          long numEssays = required_pts * elem.getValue();
          res += numEssays;
          break;
        }

        long numEssays = avail_increase * elem.getValue();
        res += numEssays;
        required_pts -= (avail_increase);

      }
      System.out.println(res);
    }
  }

}
