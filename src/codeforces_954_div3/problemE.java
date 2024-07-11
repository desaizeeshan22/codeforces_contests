package codeforces_954_div3;

import java.util.*;

public class problemE {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int tests = sc.nextInt();
    for (int t = 0; t < tests; t++) {
      int n = sc.nextInt();
      int k = sc.nextInt();
      int nums[] = new int[n];
      for (int i = 0; i < n; i++) {
        nums[i] = sc.nextInt();
      }
      Map<Integer, List<Integer>> mp = new HashMap<>();
      for (int i = 0; i < n; i++) {
        int key = nums[i] % k;
        mp.computeIfAbsent(key, v -> new ArrayList<Integer>());
        mp.get(key).add(nums[i]);
      }
      int cnt = 0;
      int res = 0;
      for (List<Integer> val : mp.values()) {
        Collections.sort(val);
        int size = val.size();
        int temp = 0;
        int temp2 = 0;
        if ((size & 1) == 1) {
          if (size == 1) {
            cnt++;
            continue;
          }
          cnt++;
          Map<Integer, Integer> pre = new HashMap<>(), suff = new HashMap<>();
          for (int i = 1; i < size - 1; i += 2) {
            temp += ((val.get(i) - val.get(i - 1)) / k);
            pre.put(i, temp);
          }


          temp = 0;
          for (int j = size - 2; j >= 1; j -= 2) {
            temp += ((val.get(j + 1) - val.get(j)) / k);
            suff.put(j, temp);
          }
          temp2 = Integer.MAX_VALUE;
          for (int i = 0; i < size; i += 2) {
            if (i == 0) {
              temp2 = Math.min(temp2, suff.get(i + 1));
            } else if (i == size - 1) {
              temp2 = Math.min(temp2, pre.get(i - 1));
            } else {
              temp2 = Math.min(temp2, pre.get(i - 1) + suff.get(i + 1));
            }
          }

          temp2 = Math.min(temp2, temp);
          res += temp2;
        } else {
          for (int i = 0; i < size; i += 2) {
            res += ((val.get(i + 1) - val.get(i)) / k);
          }
        }
      }
      if (cnt > 1) {
        System.out.println(-1);
      } else {
        System.out.println(res);
      }

    }
  }
}
