package com.zc.dp.greed;

/**
 * @author lizhecao 2021/4/2
 * @version 1.0
 */
public class JumpGameII45 {
  public int jump(int[] nums) {
    int end = 0,maxPosition = 0;
    int steps = 0;
    for (int i = 0; i< nums.length - 1; i++) {
      maxPosition = Math.max(maxPosition, nums[i] + i);
      if (i == end) {
        end = maxPosition;
        steps++;
      }
    }
    return steps;
  }
}
