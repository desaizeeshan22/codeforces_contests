package codeforces_1985;

import java.util.Scanner;

public class problemE {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int tests = sc.nextInt();
    for (int test = 0; test < tests; test++) {
      long x = sc.nextLong();
      long y = sc.nextLong();
      long z = sc.nextLong();
      long k = sc.nextLong();
      System.out.println(solution(x, y, z, k));
    }
  }

  public static long solution(long x, long y, long z, long k) {
    //    The question states there is a big box B from origin(0,0,0) to pt(x,y,z )
    //    Find a box S with volume k such that the box can be placed in maximum number of places
    //    Aka choose the dimensions of S such that maximum number of boxes can be fit inside B such that all dimensions are integers
    //    no rotations
    //    Intuition: for a 1 D from pt 0 to pt 3 on the x axis , there are three places a line segment of length can be placed
    //    given by 3-1+1 aka generalized by endpoint-dimension of subsection +1
    //    Extending to the 2D case number of squares of size(2,2) aka area of 4 places inside a square  is (4-2+1)*(4-2+1)
    //    3 squares along each axis, so the total number of squares = 3*3=9 squares
    long res = 0;
    for (int i = 1; i <= x; i++) {
      for (int j = 1; j <= y; j++) {
        if (k % (j * i) == 0) {
          res = Math.max(res, (x - i + 1) * (y - j + 1) * ((z - (k / i) / j) + 1));
        }
      }
    }
    return res;
  }
}
