package com.wesker926.leetcode.algorithms.p2258.s1;

import java.util.*;

/**
 * @author wesker.gh
 * @date 2023/11/9
 * @description BFS
 * 设人到达终点的最短时间为t1，火为t2：
 * 1.若t1 < t2，则中途人不会被烧到，可用反证法证明；
 * 2.等待t2 - t1 - 1分钟，人依然比火先到，且不会被烧到，可用反证法证明；
 * 3.若等待t2 - t1分钟时，人在终点上一个格子或者左一个格子比火先到，则可以比火先到终点。
 */
@SuppressWarnings("all")
public class Solution {

    private static final int[][] DIRS = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public int maximumMinutes(int[][] grid) {
        int[] pt = bfs(grid, List.of(new int[]{0, 0}));
        if (pt[0] < 0) return -1;

        List<int[]> fireInit = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) fireInit.add(new int[]{i, j});
            }
        }
        int[] ft = bfs(grid, fireInit);
        if (ft[0] < 0) return (int) 1e9;
        if (ft[0] < pt[0]) return -1;

        int diff = ft[0] - pt[0];
        for (int i = 1; i <= 2; i++) {
            if (pt[i] > 0 && pt[i] + diff < ft[i]) return diff;
        }
        return diff - 1;
    }

    private int[] bfs(int[][] grid, List<int[]> init) {
        int m = grid.length, n = grid[0].length;
        int[][] time = new int[m][n];
        for (int[] row : time) Arrays.fill(row, -1);
        Queue<int[]> queue = new LinkedList<>(init);
        for (int[] pos : init) time[pos[0]][pos[1]] = 0;
        for (int t = 1, cnt = queue.size(); cnt > 0; t++, cnt = queue.size()) {
            for (int i = 0; i < cnt; i++) {
                int[] cur = queue.poll();
                for (int[] dir : DIRS) {
                    int nx = cur[0] + dir[0], ny = cur[1] + dir[1];
                    if (nx >= 0 && nx < m && ny >= 0 && ny < n && grid[nx][ny] == 0 && time[nx][ny] < 0) {
                        queue.offer(new int[]{nx, ny});
                        time[nx][ny] = t;
                    }
                }
            }
        }
        return new int[]{time[m - 1][n - 1], time[m - 2][n - 1], time[m - 1][n - 2]};
    }
}
