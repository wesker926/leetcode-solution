package com.wesker926.leetcode.algorithms.p1139.s2;

/**
 * @author wesker.gh
 * @date 2023/2/17
 * @description DP（其实是前缀和）
 * 对角线，O(m * n * log(min(m, n)))，意义不大
 */
public class Solution {
    public int largest1BorderedSquare(int[][] grid) {
        int m = grid.length, n = grid[0].length, max = 0;
        int[][][] dp = new int[m + 2][n + 2][4];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    dp[i + 1][j + 1][0] = dp[i + 1][j][0] + 1;
                    dp[i + 1][j + 1][1] = dp[i][j + 1][1] + 1;
                }
                if (grid[m - i - 1][n - j - 1] == 1) {
                    dp[m - i][n - j][2] = dp[m - i][n - j + 1][2] + 1;
                    dp[m - i][n - j][3] = dp[m - i + 1][n - j][3] + 1;
                }
            }
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (grid[i - 1][j - 1] == 0) {
                    continue;
                }
                int cur = Math.min(dp[i][j][0], dp[i][j][1]);
                for (; Math.min(dp[i - cur + 1][j - cur + 1][2], dp[i - cur + 1][j - cur + 1][3]) < cur; cur--) ;
                max = Math.max(max, cur);
            }
        }
        return max * max;
    }
}
