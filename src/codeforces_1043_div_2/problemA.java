package codeforces_1043_div_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class problemA {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int tests = Integer.parseInt(br.readLine());
    while (tests-- > 0) {
      int aLen = Integer.parseInt(br.readLine());
      StringBuilder aStr = new StringBuilder(br.readLine());
      int bLen = Integer.parseInt(br.readLine());
      StringBuilder bStr = new StringBuilder(br.readLine());
      StringBuilder chances = new StringBuilder(br.readLine());
      System.out.println(result(aStr, bStr, chances, bLen));
    }
  }

  public static String result(StringBuilder a, StringBuilder b, StringBuilder chances, int length) {
    int i = 0;
    StringBuilder res = a;
    while (i < length) {
      if (chances.charAt(i) == 'D') {
        res.append(b.charAt(i));
      } else {
        StringBuilder temp = new StringBuilder(String.valueOf(b.charAt(i)));
        temp.append(res);
        res = temp;
      }
      i++;
    }
    return res.toString();
  }
}
