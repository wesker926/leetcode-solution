package com.wesker926.leetcode.algorithms.p2293.s1;

/**
 * @author wesker.gh
 * @date 2023/1/15
 * @description 模拟
 */
public class Solution {
    public int minMaxGame(int[] nums) {
        for (int len = nums.length / 2; len >= 1; len >>= 1) {
            for (int i = 0; i < len; i++) {
                nums[i] = (i & 1) == 0 ? Math.min(nums[i * 2], nums[i * 2 + 1]) : Math.max(nums[i * 2], nums[i * 2 + 1]);
            }
        }
        return nums[0];
    }
}
