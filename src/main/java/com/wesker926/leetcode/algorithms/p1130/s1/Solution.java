package com.wesker926.leetcode.algorithms.p1130.s1;

/**
 * @author wesker.gh
 * @date 2023/5/31
 * @description DP
 * DFS超时，DP虽然可过但不是最优，本体最优为贪心
 */
public class Solution {
    public int mctFromLeafValues(int[] arr) {
        int n = arr.length;
        int[][][] dp = new int[n][n][2];
        for (int i = n - 1; i >= 0; i--) {
            dp[i][i][0] = arr[i];
            for (int j = i + 1; j < n; j++) {
                dp[i][j][0] = Math.max(dp[i][i][0], dp[i + 1][j][0]);
                dp[i][j][1] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    dp[i][j][1] = Math.min(dp[i][j][1], dp[i][k][1] + dp[k + 1][j][1] + dp[i][k][0] * dp[k + 1][j][0]);
                }
            }
        }
        return dp[0][n - 1][1];
    }
}
