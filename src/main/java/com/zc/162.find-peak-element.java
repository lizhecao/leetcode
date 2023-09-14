package com.zc;

class FindPeakElement {
    public int findPeakElement(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while(end > start) {
            int mid = (end + start)/2;
            if (mid > 0 && nums[mid] > nums[mid -1] && nums[mid] > nums[mid + 1]) {
                return mid;
            }
            if (nums[mid] < nums[mid + 1]) {
                start = mid + 1;
            } else {
                end = mid -1;
            }
        }
        if (start == end) {
            return start;
        }

        return 0;
    }

    public static void main(String[] args) {
        int []nums = new int[]{1,2,1,3,5,6,4};
        System.out.println(new FindPeakElement().findPeakElement(nums));
        int []nums2 = new int[]{1,2,3,1};
        System.out.println(new FindPeakElement().findPeakElement(nums2));
        int []nums3 = new int[]{1,2};
        System.out.println(new FindPeakElement().findPeakElement(nums3));
    }
}
