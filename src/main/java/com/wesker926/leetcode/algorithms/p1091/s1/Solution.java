package com.wesker926.leetcode.algorithms.p1091.s1;

/**
 * @author wesker.gh
 * @date 2023/5/26
 * @description BFS
 * 这题不要尝试DFS了，自讨苦吃
 */
public class Solution {

    private static final int[][] DIRS = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};

    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length, step = 1;
        if (grid[0][0] != 0 || grid[n - 1][n - 1] != 0) return -1;
        int[] queue = new int[n * n + 1];
        for (int st = 0, ed = 0; st <= ed; step++) {
            for (int t = ed; st <= t; st++) {
                int x = queue[st] >> 7, y = queue[st] & 127;
                if (x == n - 1 && x == y) return step;
                for (int[] d : DIRS) {
                    int nx = x + d[0], ny = y + d[1];
                    if (nx < 0 || nx >= n || ny < 0 || ny >= n || grid[nx][ny] == 1) continue;
                    grid[nx][ny] = 1;
                    queue[++ed] = (nx << 7) | ny;
                }
            }
        }
        return -1;
    }
}
