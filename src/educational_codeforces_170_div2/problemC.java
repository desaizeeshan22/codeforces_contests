package educational_codeforces_170_div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class problemC {


  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int tests = Integer.parseInt(br.readLine());
    while (tests-- > 0) {
      StringTokenizer st1 = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st1.nextToken());
      int k = Integer.parseInt(st1.nextToken());
      int[] arr = new int[n];
      StringTokenizer st2 = new StringTokenizer(br.readLine());
      for (int i = 0; i < n; i++) {
        arr[i] = Integer.parseInt(st2.nextToken());
      }
      Arrays.sort(arr);
      int ans = 0;
      int i = 0, j = 0;
      while (i < n) {
        j = Math.max(j, i + 1);
        while (j < n && arr[j] - arr[j - 1] <= 1 && arr[j] - arr[i] < k) {
          j++;
        }
        ans = Math.max(j - i, ans);
        i++;
      }
      System.out.println(ans);
    }
  }
}
