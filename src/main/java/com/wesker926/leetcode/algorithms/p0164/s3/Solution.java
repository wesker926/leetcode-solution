package com.wesker926.leetcode.algorithms.p0164.s3;

/**
 * @author wesker.gh
 * @date 2022/6/2
 * @description 快排
 * 非线性时间复杂度
 */
public class Solution {
    public int maximumGap(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        int res = 0;
        for (int i = 1; i < nums.length; i++) {
            res = Math.max(res, nums[i] - nums[i - 1]);
        }
        return res;
    }

    private void quickSort(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }
        int i, j;
        for (i = l, j = l; j <= r; j++) {
            if (nums[j] <= nums[r]) {
                swap(nums, i++, j);
            }
        }
        quickSort(nums, l, i - 2);
        quickSort(nums, i, r);
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
