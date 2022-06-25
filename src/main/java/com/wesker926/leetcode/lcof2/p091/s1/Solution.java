package com.wesker926.leetcode.lcof2.p091.s1;

/**
 * @author wesker.gh
 * @date 2022/6/25
 * @description DP
 * 同主站-p0256
 */
public class Solution {
    public int minCost(int[][] costs) {
        int[][] dp = new int[2][3];
        for (int i = 0; i < costs.length; i++) {
            int r = i & 1, w = 1 - r;
            dp[w][0] = Math.min(dp[r][1], dp[r][2]) + costs[i][0];
            dp[w][1] = Math.min(dp[r][0], dp[r][2]) + costs[i][1];
            dp[w][2] = Math.min(dp[r][0], dp[r][1]) + costs[i][2];
        }
        int r = costs.length & 1;
        return Math.min(dp[r][0], Math.min(dp[r][1], dp[r][2]));
    }
}
