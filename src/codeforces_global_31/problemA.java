package codeforces_global_31;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class problemA {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());
    while (t-- > 0) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int l = Integer.parseInt(st.nextToken());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      Set<Integer> seen = new HashSet<>();
      int res = 0;
      int k = 0;
      while (true) {
        int val = (a + k * b) % l;
        res = Math.max(res, val);
        if (seen.contains(val)) {
          break;
        }
        seen.add(val);
        k++;
      }
      System.out.println(res);
    }
  }
}
