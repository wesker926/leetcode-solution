package com.wesker926.leetcode.algorithms.p0675.s1;

import java.util.*;

/**
 * @author wesker.gh
 * @date 2022/5/23
 * @description A*启发式搜索算法（BFS）
 * Dijkstra最短路径算法是A*的评估函数为0的特例
 */
public class Solution {

    private static final int[][] DIRS = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int cutOffTree(List<List<Integer>> forest) {
        int m = forest.size(), n = forest.get(0).size();
        List<int[]> trees = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (forest.get(i).get(j) > 1) {
                    trees.add(new int[]{i, j});
                }
            }
        }
        trees.sort(Comparator.comparingInt(t -> forest.get(t[0]).get(t[1])));
        int ans = 0, cx = 0, cy = 0, nx, ny, step;
        for (int i = 0; i < trees.size(); i++, cx = nx, cy = ny) {
            nx = trees.get(i)[0];
            ny = trees.get(i)[1];
            step = bfs(forest, cx, cy, nx, ny);
            if (step < 0) {
                return -1;
            }
            ans += step;
        }
        return ans;
    }

    private int bfs(List<List<Integer>> forest, int sx, int sy, int tx, int ty) {
        if (sx == tx && sy == ty) {
            return 0;
        }
        int m = forest.size(), n = forest.get(0).size();
        int[][] cost = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(cost[i], Integer.MAX_VALUE);
        }
        cost[sx][sy] = manhattanDist(sx, sy, tx, ty);
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        queue.offer(new int[]{cost[sx][sy], 0, sx, sy});
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            if (cur[2] == tx && cur[3] == ty) {
                return cur[1];
            }
            for (int[] dir : DIRS) {
                int nx = cur[2] + dir[0];
                int ny = cur[3] + dir[1];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && forest.get(nx).get(ny) > 0) {
                    int nCost = cur[1] + 1 + manhattanDist(nx, ny, tx, ty);
                    if (nCost < cost[nx][ny]) {
                        queue.offer(new int[]{nCost, cur[1] + 1, nx, ny});
                        cost[nx][ny] = nCost;
                    }
                }
            }
        }
        return -1;
    }

    private int manhattanDist(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}
