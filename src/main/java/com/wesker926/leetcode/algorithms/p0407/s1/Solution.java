package com.wesker926.leetcode.algorithms.p0407.s1;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author wesker.gh
 * @date 2021/11/3
 * @description dijkstra
 */
public class Solution {
    public int trapRainWater(int[][] heightMap) {
        int m = heightMap.length, n = heightMap[0].length;
        if (m <= 2 || n <= 2) {
            return 0;
        }

        boolean[][] visit = new boolean[m][n];
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {
                    queue.offer(new int[]{heightMap[i][j], i, j});
                    visit[i][j] = true;
                }
            }
        }

        int[] cur;
        int nx, ny, result = 0;
        int[] dir = new int[]{-1, 0, 1, 0, -1};
        while (!queue.isEmpty()) {
            cur = queue.poll();
            for (int i = 0; i < 4; i++) {
                nx = cur[1] + dir[i];
                ny = cur[2] + dir[i + 1];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n || visit[nx][ny]) {
                    continue;
                }
                if (heightMap[nx][ny] < cur[0]) {
                    result += cur[0] - heightMap[nx][ny];
                }
                queue.offer(new int[]{Math.max(heightMap[nx][ny], cur[0]), nx, ny});
                visit[nx][ny] = true;
            }
        }
        return result;
    }
}
