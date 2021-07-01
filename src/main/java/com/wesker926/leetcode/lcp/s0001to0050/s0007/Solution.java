package com.wesker926.leetcode.lcp.s0001to0050.s0007;

import java.util.Arrays;

/**
 * @author wesker
 * @date 2021/7/1
 * @description LCP 07. 传递信息
 */
public class Solution {
    /**
     * dp，第i轮到第j个人的方案数
     */
    public int numWays(int n, int[][] relation, int k) {
        int[][] dp = new int[2][n];
        dp[0][0] = 1;
        for (int i = 1, x, y; i <= k; i++) {
            x = i & 1;
            y = x ^ 1;
            Arrays.fill(dp[x], 0);
            for (int[] j : relation) {
                dp[x][j[1]] += dp[y][j[0]];
            }
        }
        return dp[k & 1][n - 1];
    }
}