package com.wesker926.leetcode.algorithms.p1254.s1;

/**
 * @author wesker.gh
 * @date 2023/6/18
 * @description DFS
 */
public class Solution {

    private static final int[][] DIRS = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int closedIsland(int[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[0].length; j++)
                if (grid[i][j] == 0 && !dfs(grid, i, j)) ans++;
        return ans;
    }

    private boolean dfs(int[][] grid, int x, int y) {
        boolean edge = false;
        for (int[] dir : DIRS) {
            int nx = x + dir[0], ny = y + dir[1];
            if (nx < 0 || nx >= grid.length || ny < 0 || ny >= grid[0].length) edge = true;
            else if (grid[nx][ny] == 0) {
                grid[nx][ny] = 2;
                edge |= dfs(grid, nx, ny);
            }
        }
        return edge;
    }
}
