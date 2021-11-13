package com.wesker926.leetcode.algorithms.p0375.s1;

/**
 * @author wesker.gh
 * @date 2021/11/13
 * @description dp
 */
public class Solution {
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n + 1][n + 1];
        int min;

        for (int y = 2; y <= n; y++) {
            for (int x = y - 1; x > 0; x--) {
                min = dp[x][y - 1] + y;
                for (int i = x; i < y; i++) {
                    min = Math.min(min, Math.max(dp[x][i - 1], dp[i + 1][y]) + i);
                }
                dp[x][y] = min;
            }
        }
        return dp[1][n];
    }
}
