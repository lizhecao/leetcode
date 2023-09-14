package com.zc;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lizhecao 2021/3/20
 * @version 1.0
 */
public class TwoSum1 {
  public int[] twoSum(int[] nums, int target) {
    Map<Integer,Integer> map = new HashMap<>();
    for (int i = 0;i< nums.length;i ++) {
      if (map.containsKey(target - nums[i])) {
        return new int[]{map.get(target -nums[i]), i};
      } else {
        map.put(nums[i], i);
      }
    }
    return new int[0];
  }

  // 如果是有序数组的话，还可以用双指针

  public static void main(String[] args) {
    TwoSum1 twoSum1 = new TwoSum1();
    int[] arr =new int[]{
        2,7,11,15
    };
    for (int i : twoSum1.twoSum(arr, 9)) {
      System.out.print(i);
    }
  }
}
