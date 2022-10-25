package com.wesker926.leetcode.algorithms.p0934.s2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author wesker.gh
 * @date 2022/10/25
 * @description DFS + BFS
 * 先DFS找到一个岛屿的所有边缘点，然后BFS计算最短距离
 */
public class Solution {

    private static final int[][] DIRS = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    @SuppressWarnings("all")
    public int shortestBridge(int[][] grid) {
        Queue<Integer> queue = new LinkedList<>();
        outer:
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j, queue);
                    break outer;
                }
            }
        }
        for (int ans = -1; !queue.isEmpty(); ans++) {
            for (int count = queue.size(); count > 0; count--) {
                int cur = queue.poll();
                int x = cur / 100, y = cur % 100;
                if (grid[x][y] == 1) {
                    return ans;
                }
                for (int[] dir : DIRS) {
                    int nx = x + dir[0], ny = y + dir[1];
                    if (nx < 0 || ny < 0 || nx >= grid.length || ny >= grid.length || grid[nx][ny] == -1) {
                        continue;
                    }
                    if (grid[nx][ny] == 0) {
                        grid[nx][ny] = -1;
                    }
                    queue.offer(nx * 100 + ny);
                }
            }
        }
        return -1;
    }

    private void dfs(int[][] grid, int x, int y, Queue<Integer> edge) {
        grid[x][y] = -1;
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
                dfs(grid, nx, ny, edge);
            }
        }
        if (isEdge) {
            edge.offer(x * 100 + y);
        }
    }
}
