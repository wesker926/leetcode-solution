package com.wesker926.leetcode.algorithms.p0075.s2;

/**
 * @author wesker.gh
 * @date 2022/5/5
 * @description 单向三指针
 */
public class Solution {
    public void sortColors(int[] nums) {
        for (int i = 0, j = 0, k = 0; k < nums.length; k++) {
            if (nums[k] == 1) {
                swap(nums, j++, k);
            } else if (nums[k] == 0) {
                swap(nums, i++, k);
                if (j >= i) {
                    swap(nums, j, k);
                }
                j++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
