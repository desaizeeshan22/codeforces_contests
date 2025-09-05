package codeforces_1043_div_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class problemB {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int tests = Integer.parseInt(br.readLine());
    while (tests-- > 0) {
      String numString = br.readLine();
      int digits = numString.length();
      long number = Long.parseLong(numString);
      long temp = 10;
      PriorityQueue<Long> res = new PriorityQueue<>((a, b) -> Long.compare(a, b));
      for (int i = 1; i < digits; i++) {
        long divisor = temp + 1;
        if (number % divisor == 0) {
          res.add(number / divisor);
        }
        temp = temp * 10;
      }
      if (res.isEmpty()) {
        System.out.println("0");
      } else {
        System.out.println(res.size());
        while (!res.isEmpty()) {
          System.out.print(res.poll());
          System.out.print(" ");
        }
        System.out.println();
      }
    }
  }
}
