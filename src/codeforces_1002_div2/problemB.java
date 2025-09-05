package codeforces_1002_div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class problemB {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int tests = Integer.parseInt(br.readLine());
    while (tests-- > 0) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken());
      int k = Integer.parseInt(st.nextToken());
      st = new StringTokenizer(br.readLine());
      int[] arr = new int[n];
      for (int i = 0; i < n; i++) {
        arr[i] = Integer.parseInt(st.nextToken());
      }
      if (n == k) {
        List<Integer> l = new ArrayList<>();
        for (int i = 1; i < n; i += 2) {
          l.add(arr[i]);
        }
        l.add(0);
        for (int j = 0; j < l.size(); j++) {
          if (l.get(j) != j + 1) {
            System.out.println(j + 1);
            break;
          }
        }
      } else {
        int res = 2;
        for (int i = 1; i + k <= n + 1; i++) {
          if (arr[i] != 1) {
            res = 1;
            break;
          }
        }
        System.out.println(res);
      }
    }
  }
}
