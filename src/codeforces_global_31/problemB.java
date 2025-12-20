package codeforces_global_31;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class problemB {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int tests = Integer.parseInt(br.readLine());
    while (tests-- > 0) {
      String res = "";
      int length = Integer.parseInt(br.readLine());
      StringTokenizer st = new StringTokenizer(br.readLine());
      while (length-- > 0) {
        String temp = String.valueOf(st.nextToken());
        String prepend = temp + res;
        String append = res + temp;
        if (prepend.compareTo(append) > 0) {
          res = append;
        } else {
          res = prepend;
        }
      }
      System.out.println(res);
    }
  }
}
