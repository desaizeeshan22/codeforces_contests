package codeforces_979_div_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problemC {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int tests = Integer.parseInt(st.nextToken());
    while (tests-- > 0) {
      StringTokenizer st1 = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st1.nextToken());
      StringTokenizer st2 = new StringTokenizer(br.readLine());
      char[] s = st2.nextToken().toCharArray();
      if (s[0] == '1' || s[n - 1] == '1') {
        System.out.println("YES");
      } else {
        String res = "NO";
        for (int i = 1; i < n; i++) {
          if (s[i] == '1' && s[i - 1] == s[i]) {
            res = "YES";
            break;
          }
        }
        System.out.println(res);
      }
    }
  }

}
