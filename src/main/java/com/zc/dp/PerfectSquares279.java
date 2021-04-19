package com.zc.dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author lizhecao 2021/3/20
 * @version 1.0
 */
public class PerfectSquares279 {
  public int numSquares(int n) {
    List<Integer> l = new ArrayList<>();
    for (int i = 1;i * i <= n;i++) {
      l.add(i * i);
    }

    int[] dp = new int[n + 1];
    dp[0] = 0;
    for (int i=1;i<=n;i++) {
      dp[i] = Integer.MAX_VALUE;
      for (int j=0;j<l.size();j++) {
        if (l.get(j) > i) {
          break;
        }
        dp[i] = Math.min(dp[i], dp[i-l.get(j)] + 1);
      }
    }
    return dp[n];
  }

  public static void main(String[] args) {
    Integer a = new Integer(1);
    Integer b = new Integer(1);
    if(a==b) {
      System.out.println("a=b");
    }else {
      System.out.println("a!=b");
    }
  }
}
