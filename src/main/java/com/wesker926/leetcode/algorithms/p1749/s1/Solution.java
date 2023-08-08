package com.wesker926.leetcode.algorithms.p1749.s1;

/**
 * @author wesker.gh
 * @date 2023/8/8
 * @description DP
 * 前缀和思路更简洁：子数组之和为两个前缀和的差，取前缀和的max-min即为所求结果（当max在min左侧，求的是绝对值）。
 */
public class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int ans = 0, max = 0, min = 0;
        for (int num : nums) {
            max = Math.max(max + num, num);
            min = Math.min(min + num, num);
            ans = Math.max(ans, Math.max(Math.abs(max), Math.abs(min)));
        }
        return ans;
    }
}
