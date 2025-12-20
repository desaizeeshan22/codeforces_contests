package rated_1100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem_158_B {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] groups = new int[5];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      groups[Integer.parseInt(st.nextToken())]++;
    }
    int taxis = groups[4];
    taxis += groups[3];
    groups[1] -= groups[3];
    if (groups[1] < 0) {
      groups[1] = 0;
    }
    taxis += (groups[1] + 2 * groups[2]) / 4;
    if ((groups[1] + 2 * groups[2]) % 4 > 0) {
      taxis++;
    }
    System.out.println(taxis);
  }
}
