package com.wesker926.leetcode.algorithms.p0908.s1;

/**
 * @author wesker.gh
 * @date 2022/4/30
 * @description TODO
 */
public class Solution {
    public int smallestRangeI(int[] nums, int k) {
        int max = nums[0], min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }
        return Math.max(0, max - min - k * 2);
    }
}
