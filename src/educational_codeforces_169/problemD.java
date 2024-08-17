package educational_codeforces_169;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class problemD {
  public static List<String> s = Arrays.asList(new String[] {"BG", "BR", "BY", "GR", "GY", "RY"});
  private static final int INF = (int) 1e9;

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    int tests = sc.nextInt();
    while (tests-- > 0) {
      int n = sc.nextInt();
      int q = sc.nextInt();
      int[][] lf = new int[n][6];
      int[][] rg = new int[n][6];
      int[] a = new int[n];
      for (int i = 0; i < n; i++) {
        a[i] = s.indexOf(sc.next());
      }
      for (int o = 0; o < 2; ++o) {
        int[] last = new int[6];
        Arrays.fill(last, -INF);

        for (int i = 0; i < n; ++i) {
          int index = (o == 1) ? n - i - 1 : i;
          last[a[i]] = index;
          if (o == 1) {
            System.arraycopy(last, 0, rg[n - i - 1], 0, 6);
          } else {
            System.arraycopy(last, 0, lf[i], 0, 6);
          }
        }
        reverseArray(a);
      }
      while (q-- > 0) {
        int x = sc.nextInt();
        int y = sc.nextInt();
        x--;
        y--;

        int ans = INF;

        for (int j = 0; j < 6; ++j) {
          if (a[x] + j != 5 && j + a[y] != 5) {
            ans = Math.min(ans, Math.abs(x - lf[x][j]) + Math.abs(lf[x][j] - y));
            ans = Math.min(ans, Math.abs(x - rg[x][j]) + Math.abs(rg[x][j] - y));
          }
        }
        if (ans > INF / 2) {
          ans = -1;
        }
        System.out.println(ans);
      }
    }
  }


  public static void reverseArray(int[] arr) {
    int i = 0, j = arr.length - 1;
    while (i <= j) {
      int temp = arr[i];
      arr[i] = arr[j];
      arr[j] = temp;
      i++;
      j--;
    }
  }
}
