package com.zc;

/**
 * @author lizhecao 2021/3/10
 * @version 1.0
 */
public class MissingNumber268 {
  /**
   * 数学运算
   * @param nums
   * @return
   */
  public int missingNumber(int[] nums) {
    int result = 0;
    for (int i = 0; i < nums.length; i++) {
      result += nums[i];
    }
    int n = nums.length;
    int sum = n * (n + 1) /2;
    return sum - result;
  }

  /**
   * 位运算
   * @param nums
   * @return
   */
  public int missingNumber2(int[] nums) {
    int result = 0;
    for (int i = 0; i < nums.length; i++) {
      result ^= nums[i] ^ (i + 1);
    }
    return result;
  }

  int missingNumber3(int[] nums) {
    int n = nums.length;
    int res = 0;
    for (int i = 0; i < n; i++)
      res += i + 1 - nums[i];
    return res;
  }
}
