package rated_1100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class problem_706_B {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] prices = new int[n];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int j = 0; j < n; j++) {
      prices[j] = Integer.parseInt(st.nextToken());
    }
    Arrays.sort(prices);
    int q = Integer.parseInt(br.readLine());
    while (q-- > 0) {
      int coins = Integer.parseInt(br.readLine());
      System.out.println(bs(coins, prices, n) + 1);
    }
  }

  public static int bs(int coins, int[] prices, int n) {
    int res = -1;
    int i = 0, j = n - 1;
    while (i <= j) {
      int m = i + (j - i) / 2;
      if (prices[m] > coins) {
        j = m - 1;
      } else {
        res = m;
        i = m + 1;
      }
    }
    return res;
  }
}
