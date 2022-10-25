package com.wesker926.leetcode.algorithms.p0934.s1;

import java.util.LinkedList;
import java.util.List;

/**
 * @author wesker.gh
 * @date 2022/10/25
 * @description DFS
 * 分别找出两岛边缘点，然后计算最短距离
 * 比较慢，可能是因为dfs了两个岛
 */
public class Solution {

    private static final int[][] DIRS = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    @SuppressWarnings("all")
    public int shortestBridge(int[][] grid) {
        List<Integer>[] edges = new List[2];
        for (int i = 0, c = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j] != 1) {
                    continue;
                }
                edges[c] = new LinkedList<>();
                dfs(grid, i, j, c + 2, edges[c]);
                if (++c >= 2) {
                    break;
                }
            }
        }
        int ans = grid.length * 2;
        for (int a : edges[0]) {
            for (int b : edges[1]) {
                ans = Math.min(ans, distance(a, b));
            }
        }
        return ans;
    }

    private void dfs(int[][] grid, int x, int y, int t, List<Integer> edge) {
        grid[x][y] = t;
        boolean isEdge = false;
        for (int[] dir : DIRS) {
            int nx = x + dir[0], ny = y + dir[1];
            if (nx < 0 || ny < 0 || nx >= grid.length || ny >= grid.length) {
                continue;
            }
            if (grid[nx][ny] == 0) {
                isEdge = true;
                continue;
            }
            if (grid[nx][ny] == 1) {
                dfs(grid, nx, ny, t, edge);
            }
        }
        if (isEdge) {
            edge.add(x * 100 + y);
        }
    }

    private int distance(int a, int b) {
        int ax = a / 100, ay = a % 100;
        int bx = b / 100, by = b % 100;
        return Math.abs(ax - bx) + Math.abs(ay - by) - 1;
    }
}
