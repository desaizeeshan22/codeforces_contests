package codeforces_260_div_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class problemA {
  public static long[] freq = new long[100001], dp = new long[100001];

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st1 = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st1.nextToken());
    StringTokenizer st2 = new StringTokenizer(br.readLine());
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = Integer.parseInt(st2.nextToken());
      freq[a[i]]++;
    }
    for (int i = 1; i <= 100000; i++) {
      if (i == 1) {
        dp[i] = Math.max(dp[i - 1], freq[i] * i);
      } else {
        dp[i] = Math.max(dp[i - 1], freq[i] * i + dp[i - 2]);
      }
    }
    System.out.println(Arrays.stream(dp).max().getAsLong());
  }
}

