package com.wesker926.leetcode.algorithms.p0827.s1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author wesker.gh
 * @date 2022/9/18
 * @description DFS + 遍历
 * 先DFS找出所有岛屿大小，再遍历联通
 */
public class Solution {

    private static final int[][] POS = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int largestIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length, seq = 2;
        List<Integer> areas = new ArrayList<>(List.of(0, 0));
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    areas.add(markIsland(grid, i, j, seq++));
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 0) {
                    continue;
                }
                int cur = 1;
                Set<Integer> isConnected = new HashSet<>();
                for (int[] p : POS) {
                    int nx = i + p[0], ny = j + p[1];
                    if (!isValid(grid, nx, ny) || grid[nx][ny] == 0) {
                        continue;
                    }
                    int tag = grid[nx][ny];
                    if (isConnected.contains(tag)) {
                        continue;
                    }
                    isConnected.add(tag);
                    cur += areas.get(tag);
                }
                ans = Math.max(ans, cur);
            }
        }
        return ans == 0 ? m * n : ans;
    }

    private int markIsland(int[][] grid, int x, int y, int tag) {
        if (!isValid(grid, x, y) || grid[x][y] != 1) {
            return 0;
        }
        grid[x][y] = tag;
        int area = 1;
        for (int[] p : POS) {
            area += markIsland(grid, x + p[0], y + p[1], tag);
        }
        return area;
    }

    private boolean isValid(int[][] grid, int x, int y) {
        return x >= 0 && x < grid.length && y >= 0 && y < grid[0].length;
    }
}
