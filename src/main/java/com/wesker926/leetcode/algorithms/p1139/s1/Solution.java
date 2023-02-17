package com.wesker926.leetcode.algorithms.p1139.s1;

/**
 * @author wesker.gh
 * @date 2023/2/17
 * @description DP（其实是前缀和）
 * O(m * n * min(m, n))
 */
public class Solution {
    public int largest1BorderedSquare(int[][] grid) {
        int m = grid.length, n = grid[0].length, max = 0;
        int[][][] dp = new int[m + 1][n + 1][2];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }
                int x = i + 1, y = j + 1, cur;
                dp[x][y][0] = dp[x][j][0] + 1;
                dp[x][y][1] = dp[i][y][1] + 1;
                for (cur = Math.min(dp[x][y][0], dp[x][y][1]); cur > 1; cur--) {
                    if (dp[x][y - cur + 1][1] >= cur && dp[x - cur + 1][y][0] >= cur) {
                        break;
                    }
                }
                max = Math.max(max, cur);
            }
        }
        return max * max;
    }
}
