package com.wesker926.leetcode.algorithms.p2500.s1;

import java.util.Arrays;

/**
 * @author wesker.gh
 * @date 2023/7/27
 * @description 排序
 */
public class Solution {
    public int deleteGreatestValue(int[][] grid) {
        int ans = 0, m = grid.length, n = grid[0].length;
        for (int[] row : grid) Arrays.sort(row);
        for (int i, j = 0, max; j < n; j++) {
            for (i = 0, max = 0; i < m; i++) max = Math.max(max, grid[i][j]);
            ans += max;
        }
        return ans;
    }
}
