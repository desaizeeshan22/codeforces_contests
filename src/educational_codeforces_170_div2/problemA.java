package educational_codeforces_170_div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problemA {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int tests = Integer.parseInt(br.readLine());
    while (tests-- > 0) {
      String s = new StringTokenizer(br.readLine()).nextToken();
      String t = new StringTokenizer(br.readLine()).nextToken();
      int i = 0, j = 0, pref = 0;
      while (i < s.length() && j < t.length() && s.charAt(i) == t.charAt(j)) {
        pref++;
        i++;
        j++;
      }
      if (pref > 0) {
        System.out.println(s.length() - pref + t.length() + 1);
      } else {
        System.out.println(s.length() + t.length());
      }
    }
  }
}
