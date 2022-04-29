package com.wesker926.leetcode.algorithms.p0041.s1;

/**
 * @author wesker.gh
 * @date 2022/4/29
 * @description 下标标记
 */
public class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0) {
                nums[i] = n + 1;
            }
        }
        for (int i = 0; i < n; i++) {
            int j = Math.abs(nums[i]) - 1;
            if (j < n && nums[j] > 0) {
                nums[j] = -nums[j];
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return n + 1;
    }
}
