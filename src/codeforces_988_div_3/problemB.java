package codeforces_988_div_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problemB {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int tests = Integer.parseInt(br.readLine());
    while (tests-- > 0) {
      int k = Integer.parseInt(br.readLine());
      StringTokenizer st = new StringTokenizer(br.readLine());
      int[] a = new int[k];
      int[] cnt = new int[k + 1];
      for (int i = 0; i < k; i++) {
        a[i] = Integer.parseInt(st.nextToken());
        cnt[a[i]]++;
      }
      int m = 1, n = 1;
      for (int i = 1; i <= k; i++) {
        if (cnt[i] == 0) {
          continue;
        }
        int valChecked = (k - 2) / i;
        if (cnt[valChecked] > 0 && (i * valChecked + 2) == k) {
          m = i;
          n = valChecked;
          break;
        }
      }
      System.out.print(m + " ");
      System.out.println(n);
      //      System.out.println();
    }
  }


}
