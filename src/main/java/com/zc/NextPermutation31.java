package com.zc;

/**
 * @author lizhecao 2021/3/30
 * @version 1.0
 */
public class NextPermutation31 {
  public void nextPermutation(int[] nums) {
    int len = nums.length;
    int target = len - 1;
    while (target > 0 && nums[target] <= nums[target - 1]) {
      target--;
    }
    if (target > 0) {
      int i = len - 1;
      while (nums[i] <= nums[target - 1]) {
        i--;
      }
      swap(nums, i, target - 1);
    }
    reverse(nums, target, len - 1);
  }

  private void reverse(int[] nums, int i, int j) {
    while (i < j) {
      swap(nums, i, j);
      i++;
      j--;
    }
  }

  private void swap(int[] nums, int i, int j) {
    int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
  }
}
