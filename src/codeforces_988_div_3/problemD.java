package codeforces_988_div_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class problemD {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int tests = Integer.parseInt(br.readLine());
    while (tests-- > 0) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken()), L = Integer.parseInt(st.nextToken()), power = 1, res = 0;
      ArrayList<int[]> hurdles = new ArrayList<>(n);
      ArrayList<int[]> powerUps = new ArrayList<>(m);
      PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
      for (int i = 0; i < n; i++) {
        st = new StringTokenizer(br.readLine());
        hurdles.add(new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
      }
      for (int i = 0; i < m; i++) {
        st = new StringTokenizer(br.readLine());
        powerUps.add(new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
      }
      int j = 0;
      for (int i = 0; i < n; i++) {
        int[] hurdle = hurdles.get(i);
        while (j < m && powerUps.get(j)[0] < hurdle[0]) {
          pq.add(powerUps.get(j)[1]);
          j++;
        }
        int crossing = hurdle[1] - hurdle[0] + 1;
        while (!pq.isEmpty() && power <= crossing) {
          power += pq.poll();
          res++;
        }
        if (power <= crossing) {
          res = -1;
          break;
        }
      }
      System.out.println(res);
    }
  }
}
