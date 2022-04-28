package com.wesker926.leetcode.algorithms.p0034.s1;

/**
 * @author wesker.gh
 * @date 2022/4/28
 * @description 两次二分（同lcof-p053_1）
 */
public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int l = binary(nums, target), r = binary(nums, target + 1) - 1;
        return l > r ? new int[]{-1, -1} : new int[]{l, r};
    }

    private int binary(int[] nums, int t) {
        int l = 0, r = nums.length - 1, m;
        while (l <= r) {
            m = (l + r) / 2;
            if (nums[m] < t) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return l;
    }
}
