package com.wesker926.leetcode.algorithms.p1289.s1;

/**
 * @author wesker.gh
 * @date 2023/8/10
 * @description DP + 转移优化
 */
public class Solution {
    public int minFallingPathSum(int[][] grid) {
        int n = grid.length, ans = Integer.MAX_VALUE;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            int i1 = -1, i2 = -1;
            for (int j = 0; j < n; j++) {
                dp[j] += grid[i][j];
                if (i1 == -1 || dp[j] < dp[i1]) {
                    i2 = i1;
                    i1 = j;
                } else if (i2 == -1 || dp[j] < dp[i2]) i2 = j;
            }
            if (i == n - 1) break;
            for (int j = 0, m1 = dp[i1], m2 = dp[i2]; j < n; j++)
                dp[j] = i1 != j ? m1 : m2;
        }
        for (int cur : dp) ans = Math.min(ans, cur);
        return ans;
    }
}
