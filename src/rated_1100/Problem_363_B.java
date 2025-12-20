package rated_1100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_363_B {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());
    StringTokenizer st2 = new StringTokenizer(br.readLine());
    int[] planks = new int[n];
    int[] prefix = new int[n];
    int temp = 0;
    for (int i = 0; i < n; i++) {
      planks[i] = Integer.parseInt(st2.nextToken());
      temp += planks[i];
      prefix[i] = temp;
    }
    int res = 1;
    if (k == n) {
      System.out.println(res);
    } else {

      int numPlanks = prefix[k - 1];
      for (int j = k; j < n; j++) {
        if (prefix[j] - prefix[j - k] < numPlanks) {
          numPlanks = prefix[j] - prefix[j - k];
          res = j - k + 2;
        }
      }
      System.out.println(res);
    }
  }
}

