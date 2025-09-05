package codeforces_988_div_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problemA {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int tests = Integer.parseInt(br.readLine());
    while (tests-- > 0) {
      int[] cnt = new int[21];
      int n = Integer.parseInt(br.readLine());
      StringTokenizer st = new StringTokenizer(br.readLine());
      int[] a = new int[n];
      for (int i = 0; i < n; i++) {
        a[i] = Integer.parseInt(st.nextToken());
        cnt[a[i]]++;
      }
      int res = 0;
      for (int i = 0; i <= 20; i++) {
        res += (cnt[i] / 2);
      }
      System.out.println(res);
    }
  }
}
