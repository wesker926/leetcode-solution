package com.wesker926.leetcode.lcof.p053_1.s1;

/**
 * @author wesker.gh
 * @date 2022/4/16
 * @description 两次二分
 */
public class Solution {
    public int search(int[] nums, int target) {
        return binary(nums, target + 1) - binary(nums, target);
    }

    private int binary(int[] nums, int target) {
        int l = 0, r = nums.length - 1, m;
        while (l <= r) {
            m = (l + r) / 2;
            if (nums[m] < target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return l;
    }
}
