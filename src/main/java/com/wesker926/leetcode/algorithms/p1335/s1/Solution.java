package com.wesker926.leetcode.algorithms.p1335.s1;

import java.util.Arrays;

/**
 * @author wesker.gh
 * @date 2023/5/16
 * @description DP
 * 基础DP
 */
public class Solution {

    private static final int INF = Integer.MAX_VALUE / 2;

    public int minDifficulty(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;
        int[][] dp = new int[2][n + 1];
        Arrays.fill(dp[0], INF);
        dp[0][0] = 0;
        for (int i = 1; i <= d; i++) {
            Arrays.fill(dp[1], INF);
            for (int j = i; j <= n; j++) {
                for (int k = j - 1, max = 0; k >= 0; k--) {
                    max = Math.max(max, jobDifficulty[k]);
                    dp[1][j] = Math.min(dp[1][j], max + dp[0][k]);
                }
            }
            int[] t = dp[0];
            dp[0] = dp[1];
            dp[1] = t;
        }
        return dp[0][n] >= INF ? -1 : dp[0][n];
    }
}
