package com.zc.floyd;

/**
 * @author lizhecao 2021/3/17
 * @version 1.0
 */
public class HappyNumber202 {

  public boolean isHappy(int n) {
    if (n == 1 || next(n) == 1) {
      return true;
    }
    int fast = next(n), slow = n;
    while (fast != slow) {
      if (1 == fast) {
        return true;
      }

      slow = next(slow);
      fast = next(next(fast));
    }
    return false;
  }

  private int next(int n) {
    int next = 0;
    while (n / 10 != 0) {
      int x = n % 10;
      next += x * x;
      n /= 10;
    }
    return next + n * n;
  }

  public static void main(String[] args) {
    HappyNumber202 happyNumber202 = new HappyNumber202();
    System.out.println(happyNumber202.isHappy(19));
    System.out.println(happyNumber202.isHappy(2));
    System.out.println(happyNumber202.isHappy(7));
  }
}
