package com.wesker926.leetcode.algorithms.p1140.s2;

/**
 * @author wesker.gh
 * @date 2023/2/22
 * @description DP
 * 效果比较差
 */
public class Solution {
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        int[] aft = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            aft[i] = aft[i + 1] + piles[i];
        }
        int[][] dp = new int[n][(n + 1) / 2 + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int m = 1; m <= (n + 1) / 2; m++) {
                if (i + m * 2 >= n) {
                    dp[i][m] = aft[i];
                    continue;
                }
                for (int k = 1; k <= m * 2; k++) {
                    dp[i][m] = Math.max(dp[i][m], aft[i] - dp[i + k][Math.min(Math.max(m, k), n / 2)]);
                }
            }
        }
        return dp[0][1];
    }
}
