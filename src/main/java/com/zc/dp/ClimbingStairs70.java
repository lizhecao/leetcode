package com.zc.dp;

/**
 * @author lizhecao 2021/3/20
 * @version 1.0
 */
public class ClimbingStairs70 {
  public int climbStairs(int n) {
    int pp = 0, pre = 0, cur=1;

    for (int i = 1;i <= n;i++) {
      pp = pre;
      pre = cur;
      cur = pre + pp;
    }
    return cur;
  }
}
