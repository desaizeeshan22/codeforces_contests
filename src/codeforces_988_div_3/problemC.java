package codeforces_988_div_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class problemC {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int tests = Integer.parseInt(br.readLine());
    while (tests-- > 0) {
      int n = Integer.parseInt(br.readLine());
      if (n <= 4) {
        System.out.println(-1);
        continue;
      }
      for (int i = 1; i <= n; i++) {
        if ((i % 2) == 0 && i != 4) {
          System.out.print(i + " ");
        }
      }
      System.out.print(4 + " ");
      System.out.print(5 + " ");
      for (int i = 1; i <= n; i++) {
        if ((i % 2) == 1 && i != 5) {
          System.out.print(i + " ");
        }
      }
      System.out.println();
    }
  }
}
