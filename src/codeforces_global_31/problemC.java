package codeforces_global_31;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problemC {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int tests = Integer.parseInt(br.readLine());
    while (tests-- > 0) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken());
      int k = Integer.parseInt(st.nextToken());
      if (k % 2 == 1) {
        for (int j = 0; j < k; j++) {
          System.out.print(n + " ");
        }
      } else {
        int[] res = new int[k];
        int curr = 0;
        for (int b = 30; b >= 0; b--) {
          if ((n >> b & 1) == 1) {
            for (int j = 0; j < k; j++) {
              if (j != Math.min(curr, k - 1)) {
                res[j] += (1 << b);
              }
            }
            if (curr < k) {
              curr++;
            }
          } else {
            for (int j = 0; j < curr / 2 * 2; j++)
              res[j] += (1 << b);
          }
        }
        for (int elem : res) {
          System.out.print(elem + " ");
        }
      }
      System.out.println();
    }

  }
}
