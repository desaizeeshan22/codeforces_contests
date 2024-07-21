package codeforces_959_div2;

import java.util.*;

public class problemD {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int tests = scanner.nextInt();
    while (tests-- > 0) {
      int n = scanner.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < n; i++) {
        a[i] = scanner.nextInt();
      }
      List<Integer> pos = new ArrayList<>();
      for (int i = 0; i < n; i++) {
        pos.add(i);
      }
      List<int[]> ans = new ArrayList<>();
      for (int i = n - 1; i > 0; i--) {
        int[] occ = new int[i];
        Arrays.fill(occ, -1);
        for (int j = 0; j < pos.size(); j++) {
          int pj = pos.get(j);
          if (occ[a[pj] % i] != -1) {
            ans.add(new int[] {pj, occ[a[pj] % i]});
            pos.remove(j);
            break;
          }
          occ[a[pj] % i] = pj;
        }
      }
      Collections.reverse(ans);
      System.out.println("YES");
      for (int[] pair : ans) {
        System.out.println((pair[0] + 1) + " " + (pair[1] + 1));
      }
    }
    scanner.close();
  }
}
