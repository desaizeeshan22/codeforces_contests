package codeforces_1002_div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class problemA {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int tests = Integer.parseInt(br.readLine());
    Set<Long> set = new HashSet<>();
    while (tests-- > 0) {
      int n = Integer.parseInt(br.readLine());
      Set<Long> sA = new TreeSet<>();
      long[] b = new long[n];
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int i = 0; i < n; i++) {
        sA.add(Long.parseLong(st.nextToken()));
      }
      st = new StringTokenizer(br.readLine());
      for (int i = 0; i < n; i++) {
        b[i] = Integer.parseInt(st.nextToken());
      }
      for (long elem : sA) {
        for (int j = 0; j < n; j++) {
          set.add(elem + b[j]);
        }
      }
      if (set.size() >= 3) {
        System.out.println("YES");
      } else {
        System.out.println("NO");
      }
      set.clear();
    }
  }
}
