package codeforces_955_div2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class problemD {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int test = sc.nextInt();
    for (int t = 0; t < test; t++) {
      int r = sc.nextInt();
      int c = sc.nextInt();
      int k = sc.nextInt();
      int[][] arr = new int[r][c];
      List<String> type = new ArrayList<>();
      int[][] prefix = new int[r + 1][c + 1];
      int val = 0;
      for (int i = 0; i < r; i++) {
        for (int j = 0; j < c; j++) {
          arr[i][j] = sc.nextInt();
        }
      }
      for (int i = 0; i < r; i++) {
        type.add(sc.next());
      }

      for (int i = 1; i <= r; i++) {
        for (int j = 1; j <= c; j++) {
          if (type.get(i - 1).charAt(j - 1) == '0') {
            prefix[i][j] = prefix[i - 1][j] + prefix[i][j - 1] - prefix[i - 1][j - 1] + 1;
            val += arr[i - 1][j - 1];
          } else {
            prefix[i][j] = prefix[i - 1][j] + prefix[i][j - 1] - prefix[i - 1][j - 1] - 1;
            val -= arr[i - 1][j - 1];
          }
        }
      }
      int gcd = 0;
      if (val == 0) {
        System.out.println("YES");
      } else {
        for (int i = k; i <= r; i++) {
          for (int j = k; j <= c; j++) {
            int temp = prefix[i][j] - prefix[i - k][j] - prefix[i][j - k] + prefix[i - k][j - k];
            gcd = fgcd(gcd, Math.abs(temp));
          }
        }

        if (val < 0) {
          val = -val;
        }

        if (gcd != 0 && val % gcd == 0) {
          System.out.println("YES");
        } else {
          System.out.println("NO");
        }
      }

    }
  }

  public static int fgcd(int n1, int n2) {
    if (n1 == 0) {
      return n2;
    }
    if (n2 == 0) {
      return n1;
    }
    while (n1 != 0) {
      int temp = n1;
      n1 = n1 % n2;
      n2 = temp;
    }
    return n2;
  }
}
