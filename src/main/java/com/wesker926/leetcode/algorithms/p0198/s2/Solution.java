package com.wesker926.leetcode.algorithms.p0198.s2;

/**
 * @author wesker.gh
 * @date 2022/5/31
 * @description DP
 * 记录[0, i]范围内的最大值，dp[i] = max(dp[i - 1], dp[i - 2] + num)
 */
public class Solution {
    public int rob(int[] nums) {
        int first = 0, second = 0;
        for (int num : nums) {
            int temp = first;
            first = second;
            second = Math.max(second, temp + num);
        }
        return second;
    }
}
