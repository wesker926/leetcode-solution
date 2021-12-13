package com.wesker926.leetcode.algorithms.p0807.s1;

/**
 * @author wesker.gh
 * @date 2021/12/13
 * @description 模拟遍历
 */
public class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int n = grid.length;
        int[] maxXs = new int[n], maxYs = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                maxXs[i] = Math.max(grid[i][j], maxXs[i]);
                maxYs[j] = Math.max(grid[i][j], maxYs[j]);
            }
        }

        int sum = 0, cur;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cur = Math.max(grid[i][j], Math.min(maxXs[i], maxYs[j]));
                sum += cur - grid[i][j];
            }
        }
        return sum;
    }
}
