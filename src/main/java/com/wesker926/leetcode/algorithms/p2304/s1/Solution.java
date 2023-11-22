package com.wesker926.leetcode.algorithms.p2304.s1;

/**
 * @author wesker.gh
 * @date 2023/11/22
 * @description DP
 */
public class Solution {
    public int minPathCost(int[][] grid, int[][] moveCost) {
        int m = grid.length, n = grid[0].length, ans = Integer.MAX_VALUE;
        int[][] dp = new int[2][n];
        for (int i = m - 2; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                dp[1][j] = Integer.MAX_VALUE;
                for (int k = 0; k < n; k++) {
                    dp[1][j] = Math.min(dp[1][j], dp[0][k] + grid[i + 1][k] + moveCost[grid[i][j]][k]);
                }
            }
            int[] temp = dp[0];
            dp[0] = dp[1];
            dp[1] = temp;
        }
        for (int i = 0; i < n; i++) ans = Math.min(ans, dp[0][i] + grid[0][i]);
        return ans;
    }
}
