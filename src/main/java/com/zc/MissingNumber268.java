package com.zc;

/**
 * @author lizhecao 2021/3/10
 * @version 1.0
 */
public class MissingNumber268 {
  public int missingNumber(int[] nums) {
    int result = 0;
    for (int i = 0; i < nums.length; i++) {
      result += nums[i];
    }
    int n = nums.length;
    int sum = n * (n + 1) /2;
    return sum - result;
  }
}
