package com.wesker926.leetcode.algorithms.p1219.s1;

/**
 * @author wesker.gh
 * @date 2022/2/5
 * @description DFS + 回溯
 */
public class Solution {

    private static final int[][] DIRS = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    private int[][] grid;

    private int cur, max, m, n;

    public int getMaximumGold(int[][] grid) {
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;
        cur = 0;
        max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 0) {
                    dfs(i, j);
                }
            }
        }
        return max;
    }

    public void dfs(int i, int j) {
        int temp = grid[i][j];
        grid[i][j] = 0;
        cur += temp;
        max = Math.max(cur, max);
        for (int[] d : DIRS) {
            int ni = i + d[0], nj = j + d[1];
            if (ni >= 0 && ni < m && nj >= 0 && nj < n && grid[ni][nj] != 0) {
                dfs(ni, nj);
            }
        }
        cur -= temp;
        grid[i][j] = temp;
    }
}
