package codeforces_978_div_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problemB {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int tests = Integer.parseInt(br.readLine());
    while (tests-- > 0) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      long n = Long.parseLong(st.nextToken());
      long x = Long.parseLong(st.nextToken());
      long s = 0, mx = 0;
      st = new StringTokenizer(br.readLine());
      for (int i = 0; i < n; i++) {
        int temp = Integer.parseInt(st.nextToken());
        mx = Math.max(mx, temp);
        s += temp;
      }
      long ans = (s / x) + (s % x == 0 ? 0 : 1);
      System.out.println(Math.max(mx, ans));
    }
  }
}
