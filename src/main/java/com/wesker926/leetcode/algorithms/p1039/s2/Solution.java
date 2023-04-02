package com.wesker926.leetcode.algorithms.p1039.s2;

/**
 * @author wesker.gh
 * @date 2023/4/2
 * @description DP
 * 本题记忆化搜索可以直接翻译为迭代DP
 * 注：
 * dp[i][j]由dp[k][j]转移而来，i < k，因此i倒着枚举
 * dp[i][j]由dp[i][k]转移而来，k < j，因此j正着枚举
 */
public class Solution {
    public int minScoreTriangulation(int[] values) {
        int n = values.length;
        int[][] dp = new int[n][n];
        for (int i = n - 3; i >= 0; i--) {
            for (int j = i + 2; j < n; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j], values[i] * values[j] * values[k] + dp[i][k] + dp[k][j]);
                }
            }
        }
        return dp[0][n - 1];
    }
}
