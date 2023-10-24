package com.wesker926.leetcode.algorithms.p1155.s1;

/**
 * @author wesker.gh
 * @date 2023/10/24
 * @description DP
 * 可以只用一维数组（倒序遍历）
 */
public class Solution {

    private static final int MOD = (int) 1e9 + 7;

    public int numRollsToTarget(int n, int k, int target) {
        if (target < n || target > n * k) return 0;
        long[][] dp = new long[2][n * k + 1];
        for (int i = 1; i <= k; i++) dp[0][i]++;
        for (int c = 2; c <= n; c++) {
            for (int i = c - 1; i <= (c - 1) * k; i++) {
                for (int j = 1; j <= k; j++) {
                    dp[1][i + j] = (dp[1][i + j] + dp[0][i]) % MOD;
                }
            }
            dp[0] = dp[1];
            dp[1] = new long[n * k + 1];
        }
        return (int) dp[0][target];
    }
}
