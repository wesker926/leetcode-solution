package com.wesker926.leetcode.algorithms.p2596.s2;

/**
 * @author wesker.gh
 * @date 2023/9/13
 * @description 模拟
 */
public class Solution {

    private static final int[][] DIRS = new int[][]{{1, 2}, {1, -2}, {2, 1}, {2, -1}, {-1, 2}, {-1, -2}, {-2, 1}, {-2, -1}};

    public boolean checkValidGrid(int[][] grid) {
        if (grid[0][0] != 0) return false;
        int n = grid.length;
        outer:
        for (int i = 0, x = 0, y = 0; i < n * n - 1; i++) {
            for (int[] dir : DIRS) {
                int nx = x + dir[0], ny = y + dir[1];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n && grid[nx][ny] == i + 1) {
                    x = nx;
                    y = ny;
                    continue outer;
                }
            }
            return false;
        }
        return true;
    }
}
