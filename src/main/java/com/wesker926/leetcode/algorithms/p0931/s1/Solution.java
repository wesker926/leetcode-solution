package com.wesker926.leetcode.algorithms.p0931.s1;

/**
 * @author wesker.gh
 * @date 2023/7/13
 * @description DP
 */
public class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length, pre = 0;
        int[][] dp = new int[2][n + 2];
        for (int[] row : dp) row[0] = row[n + 1] = Integer.MAX_VALUE;
        for (int[] row : matrix) {
            for (int i = 0; i < row.length; i++)
                dp[1 - pre][i + 1] = Math.min(dp[pre][i], Math.min(dp[pre][i + 1], dp[pre][i + 2])) + row[i];
            pre = 1 - pre;
        }
        int ans = Integer.MAX_VALUE;
        for (int col : dp[pre]) ans = Math.min(ans, col);
        return ans;
    }
}
