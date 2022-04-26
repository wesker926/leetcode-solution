package com.wesker926.leetcode.algorithms.p0883.s1;

/**
 * @author wesker.gh
 * @date 2022/4/26
 * @description 遍历
 */
public class Solution {
    public int projectionArea(int[][] grid) {
        int ans = 0, n = grid.length;
        for (int i = 0, maxX = 0, maxY = 0; i < n; i++, maxX = 0, maxY = 0) {
            for (int j = 0; j < n; j++) {
                ans += grid[i][j] == 0 ? 0 : 1;
                maxX = Math.max(maxX, grid[i][j]);
                maxY = Math.max(maxY, grid[j][i]);
            }
            ans += maxX + maxY;
        }
        return ans;
    }
}
