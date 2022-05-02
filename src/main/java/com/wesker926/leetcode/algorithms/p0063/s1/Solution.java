package com.wesker926.leetcode.algorithms.p0063.s1;

/**
 * @author wesker.gh
 * @date 2022/5/2
 * @description DP
 */
public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[j] = obstacleGrid[i - 1][j - 1] == 1 ? 0 : dp[j] + dp[j - 1];
            }
        }
        return dp[n];
    }
}
