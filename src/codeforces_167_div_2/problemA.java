package codeforces_167_div_2;

import java.util.Scanner;

public class problemA {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int coins = sc.nextInt();

    //    If all coins move down by one we can think of the player moving up by one instead of all coins moving up by one
    //    So any y coordinate >= -1 is reachable by the player since for every move the player moves up by one, so y coordinates below -1 cannot
    //    be reached
    for (int t = 0; t < coins; t++) {
      int x = sc.nextInt();
      int y = sc.nextInt();
      if (y >= -1) {
        System.out.println("YES");
      } else {
        System.out.println("NO");
      }
    }
  }


}
