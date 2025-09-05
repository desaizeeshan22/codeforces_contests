package codeforces_979_div_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problemB {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int tests = Integer.parseInt(st.nextToken());
    while (tests-- > 0) {
      StringTokenizer st1 = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st1.nextToken());
      System.out.print(1);
      for (int i = 1; i < n; i++) {
        System.out.print(0);
      }
      System.out.println();
    }
  }
}
