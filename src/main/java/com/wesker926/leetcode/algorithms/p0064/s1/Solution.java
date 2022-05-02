package com.wesker926.leetcode.algorithms.p0064.s1;

import java.util.Arrays;

/**
 * @author wesker.gh
 * @date 2022/5/2
 * @description DP
 */
public class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[1] = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[j] = Math.min(dp[j - 1], dp[j]) + grid[i - 1][j - 1];
            }
        }
        return dp[n];
    }
}
