package codeforces_974_div_3;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class problemD {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int tests = sc.nextInt();
    while (tests-- > 0) {
      int n = sc.nextInt();
      int d = sc.nextInt();
      int k = sc.nextInt();
      int[][] jobs = new int[k][2];
      for (int i = 0; i < k; i++) {
        int[] job = new int[2];
        job[0] = sc.nextInt();
        job[1] = sc.nextInt();
        jobs[i] = job;
      }
      Arrays.sort(jobs, (a, b) -> (a[0] - b[0]));
      PriorityQueue<Integer> pq = new PriorityQueue<>();
      int b_start = 1, m_start = 1;
      int b_overlaps = Integer.MIN_VALUE;
      int m_overlaps = Integer.MAX_VALUE;
      for (int start = 1, idx = 0; start + d - 1 <= n; start++) {
        while (idx < k && start + d - 1 >= jobs[idx][0]) {
          pq.add(jobs[idx][1]);
          idx++;
        }
        while (!pq.isEmpty() && pq.peek() < start) {
          pq.poll();
        }
        if (b_overlaps < pq.size()) {
          b_overlaps = pq.size();
          b_start = start;
        }
        if (pq.size() < m_overlaps) {
          m_overlaps = pq.size();
          m_start = start;
        }
      }
      System.out.print(b_start);
      System.out.print(" ");
      System.out.print(m_start);
      System.out.println();
    }
  }


}
