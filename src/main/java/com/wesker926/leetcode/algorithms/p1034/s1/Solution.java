package com.wesker926.leetcode.algorithms.p1034.s1;

/**
 * @author wesker.gh
 * @date 2021/12/7
 * @description dfs
 */
public class Solution {

    private static final int[][] POS = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    private int m, n, ti, tj;

    private int[][] g;

    private boolean[][] v;

    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        g = grid;
        m = grid.length;
        n = grid[0].length;
        ti = row;
        tj = col;
        v = new boolean[m][n];
        dfs(ti, tj);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (v[i][j] && check(i, j)) {
                    g[i][j] = color;
                }
            }
        }
        return g;
    }

    private void dfs(int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n || v[i][j] || g[i][j] != g[ti][tj]) {
            return;
        }

        v[i][j] = true;
        for (int[] p : POS) {
            dfs(i + p[0], j + p[1]);
        }
    }

    private boolean check(int i, int j) {
        if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {
            return true;
        }

        for (int[] p : POS) {
            if (!v[i + p[0]][j + p[1]]) {
                return true;
            }
        }

        return false;
    }
}
