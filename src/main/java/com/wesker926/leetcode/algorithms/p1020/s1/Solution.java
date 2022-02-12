package com.wesker926.leetcode.algorithms.p1020.s1;

/**
 * @author wesker.gh
 * @date 2022/2/12
 * @description DFS - 找非飞地的陆地
 */
public class Solution {

    private static final int[][] DIRS = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    private int cur;

    public int numEnclaves(int[][] grid) {
        int ans = 0, m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    cur = 0;
                    dfs(grid, i, j);
                    ans += Math.max(cur, 0);
                }
            }
        }
        return ans;
    }

    private void dfs(int[][] grid, int i, int j) {
        grid[i][j] = 0;
        cur = cur < 0 ? -1 : cur + 1;
        for (int[] dir : DIRS) {
            int ni = i + dir[0], nj = j + dir[1];
            if (ni < 0 || nj < 0 || ni >= grid.length || nj >= grid[0].length) {
                cur = -1;
                continue;
            }

            if (grid[ni][nj] == 0) {
                continue;
            }

            dfs(grid, ni, nj);
        }
    }
}
