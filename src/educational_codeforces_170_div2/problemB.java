package educational_codeforces_170_div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problemB {
  public static long MOD = (long) 1e9 + 7;

  public static long[] powers() {
    long[] res = new long[100001];
    res[0] = 1;
    for (int i = 1; i < res.length; i++) {
      long temp = (res[i - 1] << 1) % MOD;
      res[i] = temp;
    }
    return res;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    long[] p = powers();
    int n = Integer.parseInt(br.readLine());
    StringTokenizer st1 = new StringTokenizer(br.readLine());
    StringTokenizer st2 = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      int c = Integer.parseInt(st1.nextToken());
      int k = Integer.parseInt(st2.nextToken());
      if (c == k || k == 0) {
        System.out.println(1);
      } else {
        System.out.println(p[k]);
      }
    }
  }


}
