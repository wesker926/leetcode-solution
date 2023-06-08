package com.wesker926.leetcode.algorithms.p1240.s1;

/**
 * @author wesker.gh
 * @date 2023/6/8
 * @description 暴力回溯
 * 这题有论文，参考官解
 * https://leetcode.cn/problems/tiling-a-rectangle-with-the-fewest-squares/solutions/2300093/pu-ci-zhuan-by-leetcode-solution-r1bk/
 * isAvailable不清楚原理
 */
public class Solution {
    public int tilingRectangle(int n, int m) {
        return dfs(new boolean[n][m], 0, 0, 0, new int[]{Integer.MAX_VALUE})[0];
    }

    private int[] dfs(boolean[][] grid, int x, int y, int cnt, int[] ans) {
        if (cnt >= ans[0]) return ans;
        int m = grid.length, n = grid[0].length;
        if (x >= m) {
            ans[0] = cnt;
            return ans;
        }
        for (; y < n && grid[x][y]; y++) ;
        if (y >= n) return dfs(grid, x + 1, 0, cnt, ans);
        int k = Math.min(m - x, n - y);
        if (!isAvailable(grid, x, y, k)) return ans;
        for (; k >= 1; k--) {
            flip(grid, x, y, k);
            ans = dfs(grid, x, y + k, cnt + 1, ans);
            flip(grid, x, y, k);
        }
        return ans;
    }

    private boolean isAvailable(boolean[][] rect, int x, int y, int k) {
        for (int i = 0; i < k; i++)
            for (int j = 0; j < k; j++)
                if (rect[x + i][y + j]) return false;
        return true;
    }

    private void flip(boolean[][] grid, int x, int y, int k) {
        for (int i = 0; i < k; i++)
            for (int j = 0; j < k; j++)
                grid[x + i][y + j] = !grid[x + i][y + j];
    }
}
