package com.wesker926.leetcode.lcof.p047.s1;

/**
 * @author wesker.gh
 * @date 2022/4/15
 * @description DP
 */
public class Solution {
    public int maxValue(int[][] grid) {
        int n = grid[0].length;
        int[] dp = new int[n + 1];
        for (int[] row : grid) {
            for (int j = 1; j <= n; j++) {
                dp[j] = Math.max(dp[j], dp[j - 1]) + row[j - 1];
            }
        }
        return dp[n];
    }
}
