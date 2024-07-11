package codeforces_epic_div2_div_1;

import java.util.*;

public class problemD {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int tests = sc.nextInt();
    for (int t = 0; t < tests; t++) {
      int n = sc.nextInt();
      int[] cakes = new int[n];
      Map<Integer, Integer> mp = new TreeMap<>();

      for (int i = 0; i < n; i++) {
        cakes[i] = sc.nextInt();
        mp.put(cakes[i], mp.getOrDefault(cakes[i], 0) + 1);
      }
      List<Integer> vec = new ArrayList<>(mp.values());
      int sz = vec.size();

      //      dp[i][x] number of moves left with Bob if Alice picks x elements till subarray i
      //      dp[i][x]=Math.max(dp[i-1][x-1]+1,dp[i-1][x]-freq[i]) Maximum of moves left if alice eats x-1 cakes till i-1 and is able to eat a cake at index i
      //      plus one since Bob is also able to use a move and if index i is blocked By bob then the total moves available is the number of moves
      //      to eat x cakes till subarray of index i-1  minus frequency or the number of cakes at index i since Bob has utilized all the cakes at index i


      int[][] dp = new int[sz][sz + 1];
      for (int[] row : dp) {
        Arrays.fill(row, -1);
      }
      dp[0][1] = 1;

      for (int i = 1; i < sz; i++) {
        for (int j = 1; j <= sz; j++) {
          dp[i][j] = -1;
          if (dp[i - 1][j - 1] != -1) {
            dp[i][j] = dp[i - 1][j - 1] + 1;
          }
          if (dp[i - 1][j] >= vec.get(i)) {
            if (dp[i][j] == -1) {
              dp[i][j] = dp[i - 1][j] - vec.get(i);
            } else {
              dp[i][j] = Math.max(dp[i][j], dp[i - 1][j] - vec.get(i));
            }
          }
        }
      }

      int ans = -1;
      for (int i = 1; i <= sz; i++) {
        if (dp[sz - 1][i] != -1) {
          ans = i;
          break;
        }
      }

      System.out.println(ans);
    }
  }

}



