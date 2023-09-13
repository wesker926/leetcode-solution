package com.wesker926.leetcode.algorithms.p2596.s1;

/**
 * @author wesker.gh
 * @date 2023/9/13
 * @description 模拟
 */
public class Solution {
    public boolean checkValidGrid(int[][] grid) {
        if (grid[0][0] != 0) return false;
        int n = grid.length;
        int[][] pos = new int[n * n][];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) pos[grid[i][j]] = new int[]{i, j};
        }
        for (int i = 0; i < pos.length - 1; i++) {
            int dx = Math.abs(pos[i][0] - pos[i + 1][0]);
            int dy = Math.abs(pos[i][1] - pos[i + 1][1]);
            if (dx * dy != 2) return false;
        }
        return true;
    }
}
