//F. Final Boss
//    time limit per test2 seconds
//    memory limit per test256 megabytes
//    inputstandard input
//    outputstandard output
//    You are facing the final boss in your favorite video game. The boss enemy has h
//    health. Your character has n
//    attacks. The i
//    'th attack deals ai
//    damage to the boss but has a cooldown of ci
//    turns, meaning the next time you can use this attack is turn x+ci
//    if your current turn is x
//    . Each turn, you can use all attacks that are not currently on cooldown, all at once. If all attacks are on cooldown, you do nothing for the turn and skip to the next turn.
//
//    Initially, all attacks are not on cooldown. How many turns will you take to beat the boss? The boss is beaten when its health is 0
//    or less.
//
//    Input
//    The first line contains t
//    (1≤t≤104
//    )  – the number of test cases.
//
//    The first line of each test case contains two integers h
//    and n
//    (1≤h,n≤2⋅105
//    ) – the health of the boss and the number of attacks you have.
//
//    The following line of each test case contains n
//    integers a1,a2,...,an
//    (1≤ai≤2⋅105
//    ) – the damage of your attacks.
//
//    The following line of each test case contains n
//    integers c1,c2,...,cn
//    (1≤ci≤2⋅105
//    ) – the cooldown of your attacks.
//
//    It is guaranteed that the sum of h
//    and n
//    over all test cases does not exceed 2⋅105
//    .
//
//    Output
//    For each test case, output an integer, the minimum number of turns required to beat the boss.
package codeforces_1985;

import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

import static java.util.Map.entry;


public class problemF {
  //  Intuition
  //  Simply store the earliest available attack based on the cooldown period in a priority queue
  //  Mistake made:Decreasing turn one by one which is infeasible for large cooldown periods
  //  At every iteration keep track of the last executed or available turn at the top of the priority queue
  //  if the health becomes less than or equal to 0 then the last executed turn is when the boss was slayed
  //  At every iteration append the attack and the cooldown of attack plus current turn, since it is a priority queue
  //  it always stores the earlies available attack and updates the next turn at every iteration
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int test = sc.nextInt();
    for (int t = 0; t < test; t++) {
      long h = sc.nextLong();
      int n = sc.nextInt();
      long[] attacks = new long[n], cooldown = new long[n];
      PriorityQueue<Map.Entry<Long, Integer>> q = new PriorityQueue<>((a, b) -> Long.compare(a.getKey(), b.getKey()));
      for (int j = 0; j < n; j++) {
        attacks[j] = sc.nextLong();
        q.add(entry(1l, j));
      }
      for (int k = 0; k < n; k++) {
        cooldown[k] = sc.nextLong();
      }
      long turn = 1;

      while (h > 0) {
        Map.Entry<Long, Integer> entry = q.poll();
        int currIndex = entry.getValue();
        long currTurn = entry.getKey();
        turn = currTurn;
        h -= attacks[currIndex];
        q.add(entry(currTurn + cooldown[currIndex], currIndex));
      }
      System.out.println(turn);
    }
  }
}
