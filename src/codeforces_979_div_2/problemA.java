package codeforces_979_div_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class problemA {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int tests = Integer.parseInt(st.nextToken());
    while (tests-- > 0) {
      StringTokenizer st2 = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st2.nextToken());
      StringTokenizer st3 = new StringTokenizer(br.readLine());
      int[] arr = new int[n], b = new int[n], c = new int[n], temp = new int[n];
      int maxElem = Integer.MIN_VALUE, minElem = Integer.MAX_VALUE, minIdx = 0, maxIdx = 0;
      for (int i = 0; i < n; i++) {
        arr[i] = Integer.parseInt(st3.nextToken());
        //        if (arr[i] < minElem) {
        //          minElem = arr[i];
        //          minIdx = i;
        //        }
        //        if (arr[i] > maxElem) {
        //          maxElem = arr[i];
        //          maxIdx = i;
        //        }
      }
      Arrays.sort(arr);
      swap(arr, 0, n - 1);
      for (int i = 1; i < n; i++) {
        temp[i] = arr[i];
      }
      Arrays.sort(temp);
      b[0] = arr[0];
      c[0] = arr[0];
      int score = 0;
      for (int i = 1; i < n; i++) {
        b[i] = Math.min(temp[i], b[i - 1]);
        c[i] = Math.max(temp[i], c[i - 1]);
        score += (c[i] - b[i]);
      }
      System.out.println(score);
    }
  }

  public static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
}
