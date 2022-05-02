package com.wesker926.leetcode.algorithms.p0062.s1;

/**
 * @author wesker.gh
 * @date 2022/5/2
 * @description DP
 */
public class Solution {
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[j] += dp[j - 1];
            }
        }
        return dp[n];
    }
}
