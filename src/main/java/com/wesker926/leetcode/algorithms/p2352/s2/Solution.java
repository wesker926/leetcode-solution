package com.wesker926.leetcode.algorithms.p2352.s2;

import java.util.Arrays;

/**
 * @author wesker.gh
 * @date 2023/6/6
 * @description 暴力
 * 这样暴力更快
 */
public class Solution {
    public int equalPairs(int[][] grid) {
        int ans = 0, n = grid.length;
        for (int i = 0; i < n; i++) {
            int[] col = new int[n];
            for (int j = 0; j < n; j++) col[j] = grid[j][i];
            for (int[] row : grid) {
                if (Arrays.equals(col, row)) ans++;
            }
        }
        return ans;
    }
}
