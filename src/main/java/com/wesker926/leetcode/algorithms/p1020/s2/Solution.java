package com.wesker926.leetcode.algorithms.p1020.s2;

/**
 * @author wesker.gh
 * @date 2022/2/12
 * @description DFS - 删除边缘陆地
 */
public class Solution {

    private static final int[][] DIRS = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    public int numEnclaves(int[][] grid) {
        int ans = 0, m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            dfs(grid, i, 0);
            dfs(grid, i, n - 1);
        }
        for (int i = 0; i < n; i++) {
            dfs(grid, 0, i);
            dfs(grid, m - 1, i);
        }
        for (int[] i : grid) {
            for (int j = 0; j < n; j++) {
                ans += i[j];
            }
        }
        return ans;
    }

    private void dfs(int[][] grid, int i, int j) {
        if (grid[i][j] == 0) {
            return;
        }
        grid[i][j] = 0;
        for (int[] dir : DIRS) {
            int ni = i + dir[0], nj = j + dir[1];
            if (ni >= 0 && nj >= 0 && ni < grid.length && nj < grid[0].length) {
                dfs(grid, ni, nj);
            }
        }
    }
}
