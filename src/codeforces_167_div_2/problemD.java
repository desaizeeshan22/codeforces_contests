package codeforces_167_div_2;

import java.util.*;

public class problemD {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int m = sc.nextInt();
    long[] forge = new long[n];
    long[] melt = new long[n];
    long maxIngots = 0;
    List<Long> metals = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      forge[i] = sc.nextLong();
      maxIngots = Math.max(forge[i], maxIngots);
    }
    for (int i = 0; i < n; i++) {
      melt[i] = sc.nextLong();
    }
    for (int i = 0; i < m; i++) {
      metals.add(sc.nextLong());
    }

    List<Map.Entry<Long, Long>> l = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      l.add(Map.entry(forge[i], melt[i]));
    }
    Collections.sort(l, (a, b) -> Long.compare(a.getKey() - a.getValue(), (b.getKey() - b.getValue())));
    Collections.sort(metals, Collections.reverseOrder());
    int j = 0;
    long res = 0;
    while (j < m) {
      for (int i = 0; i < n; i++) {
        Map.Entry<Long, Long> v = l.get(i);
        long currIngots = metals.get(j);
        if (v.getKey() <= currIngots) {
          long diff = (v.getKey() - v.getValue());
          long k = (long) Math.ceil((currIngots - v.getValue()) / diff);
          long newIngots = currIngots - (k * diff);
          res += (2 * k);
          if (newIngots >= currIngots) {
            newIngots -= diff;
            res += 2;
          }
          metals.set(j, newIngots);
        }
      }
      j++;
    }
    System.out.println((res));
  }
}

