package com.zc.floyd;

/**
 * @author lizhecao 2021/3/19
 * @version 1.0
 */
public class FindTheDuplicateNumber287 {
  public int findDuplicate(int[] nums) {
    int low = 1;
    int high = nums.length - 1;
    while (low < high) {
      int total = 0;
      int mid = (low + high) / 2;
      for (int num: nums) {
        if (num <= mid) {
          total ++;
        }
      }
      if (total > mid) {
        high = mid;
      } else {
        low = mid + 1;
      }
    }
    return low;
  }

  public static void main(String[] args) {
    FindTheDuplicateNumber287 f = new FindTheDuplicateNumber287();
    int[] a1 = new int[]{1,3,4,2,2};
    System.out.println(f.findDuplicate(a1));
    int[] a2 = new int[]{1,4,4,2,4};
    System.out.println(f.findDuplicate(a2));
  }
}
