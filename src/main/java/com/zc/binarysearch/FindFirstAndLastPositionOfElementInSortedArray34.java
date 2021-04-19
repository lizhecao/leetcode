package com.zc.binarysearch;

/**
 * @author lizhecao 2021/3/21
 * @version 1.0
 */
public class FindFirstAndLastPositionOfElementInSortedArray34 {
  public int[] searchRange(int[] nums, int target) {
    int left = binarySearch(nums, target, true);
    int right = binarySearch(nums, target, false) - 1;
    if (left >= nums.length || nums[left] != target) {
      return new int[]{-1, -1};
    } else {
      return new int[]{left, right};
    }
  }

  private int binarySearch(int[] nums, int target, boolean leftSide) {
    int left = 0, right = nums.length - 1;
    int mid = left + (right - left) / 2;
    while (left <= right) {
      if (nums[mid] == target) {
        if (leftSide) {
          right = mid - 1;
        } else {
          left = mid + 1;
        }
      } else if (nums[mid] > target) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    return left;
  }
}
