package com.zc.dp;

/**
 * 最长回文字串，动态规划的一种思路
 *
 *
 * @author lizhecao 2021/3/20
 * @version 1.0
 */
public class LongestPalindromicSubstring5 {
  public String longestPalindrome(String s) {
    //
    int len = s.length();
    boolean [][]dp = new boolean[len][len];
    int result = 1;
    int left = 0, right = 0;
    for (int i = len -1;i>=0;i--) {
      for (int j=i;j<len;j++) {
        dp[i][j] = i == j || i + 1 == j && s.charAt(i) == s.charAt(j) || dp[i + 1][j - 1] &&  s.charAt(i) == s.charAt(j);
        if (dp[i][j]) {
          if (j - i + 1 > result) {
            result = j - i + 1;
            left = i;
            right = j;
          }
        }
      }
    }
    return s.substring(left, right + 1);
  }
}
