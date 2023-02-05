package com.wesker926.leetcode.algorithms.p1210.s1;

/**
 * @author wesker.gh
 * @date 2023/2/5
 * @description DP
 * 在每种形态完成各自的转移后，额外考虑形态的转换
 * 这题还有BFS解法，BFS可以用三元组来控制移动，第三维是水平或竖直
 */
public class Solution {

    private static final int INF = Integer.MAX_VALUE / 2;

    public int minimumMoves(int[][] grid) {
        int n = grid.length;
        int[][] dp = new int[n][2];
        for (int j = 0; j < n; j++) {
            dp[j][0] = dp[j][1] = INF;
        }
        dp[1][0] = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                boolean tl = grid[i][j] == 0, tr = grid[i][j + 1] == 0;
                boolean bl = i + 1 < n && grid[i + 1][j] == 0, br = i + 1 < n && grid[i + 1][j + 1] == 0;
                dp[j + 1][0] = tl && tr ? Math.min(dp[j][0], dp[j + 1][0]) + 1 : INF;
                dp[j + 1][1] = tl && bl ? Math.min(dp[j][1], dp[j + 1][1]) + 1 : INF;
                if (dp[j + 1][1] < INF && tr && br && dp[j + 1][1] + 1 < dp[j + 1][0]) {
                    dp[j + 1][0] = dp[j + 1][1] + 1;
                }
                if (dp[j + 1][0] < INF && bl && br && dp[j + 1][0] + 1 < dp[j + 1][1]) {
                    dp[j + 1][1] = dp[j + 1][0] + 1;
                }
            }
        }
        return dp[n - 1][0] < INF ? dp[n - 1][0] : -1;
    }
}
