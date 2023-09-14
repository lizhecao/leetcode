package com.zc;

import java.util.Arrays;

class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        int []arr = new int[n];
        for (int i = 0;i < n;i++) {
            if (nums[i] < n+1 && nums[i] > 0) {
                arr[nums[i] - 1] = 1;
            }
        }
        for (int i = 0;i < n;i++) {
            if (arr[i] == 0) {
                return i + 1;
            }
        }
        return n + 1;
    }

    public static void main(String[] args) {
        int []arr = new int[]{7,8,9,11,12};
        System.out.println(new FirstMissingPositive().firstMissingPositive(arr));
        int []arr2 = new int[]{2};
        System.out.println(new FirstMissingPositive().firstMissingPositive(arr2));
    }
}
