package com.wesker926.leetcode.algorithms.p0905.s1;

/**
 * @author wesker.gh
 * @date 2022/4/28
 * @description 双指针
 */
public class Solution {
    public int[] sortArrayByParity(int[] nums) {
        for (int i = 0, j = 0; j < nums.length; j++) {
            if ((nums[j] & 1) == 0) {
                swap(nums, i++, j);
            }
        }
        return nums;
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
