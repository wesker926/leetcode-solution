package com.wesker926.leetcode.algorithms.p0741.s1;

import java.util.Arrays;

/**
 * @author wesker.gh
 * @date 2022/7/10
 * @description 三维DP
 * 重要：把一来一回转换成两个人同时走
 * k为x+y，x1和x2分别为两个人的x坐标
 * 当坐标相同时，只加一次grid
 * 可以假设x2>=x1，即第二个人总是位于下半轮廓
 * 倒序x1x2可以节省k这一维的空间
 */
public class Solution {
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], Integer.MIN_VALUE);
        }
        dp[1][1] = 0;
        for (int k = 0; k < n * 2 - 1; k++) {
            for (int x1 = Math.min(k, n - 1); x1 >= Math.max(0, k - n + 1); x1--) {
                for (int x2 = Math.min(k, n - 1); x2 >= x1; x2--) {
                    int y1 = k - x1, y2 = k - x2;
                    if (grid[x1][y1] == -1 || grid[x2][y2] == -1) {
                        dp[x1 + 1][x2 + 1] = Integer.MIN_VALUE;
                        continue;
                    }
                    dp[x1 + 1][x2 + 1] = Math.max(
                            Math.max(dp[x1][x2], dp[x1 + 1][x2 + 1]), Math.max(dp[x1 + 1][x2], dp[x1][x2 + 1])) +
                            (x1 == x2 ? grid[x1][y1] : grid[x1][y1] + grid[x2][y2]);
                }
            }
        }
        return Math.max(dp[n][n], 0);
    }
}
