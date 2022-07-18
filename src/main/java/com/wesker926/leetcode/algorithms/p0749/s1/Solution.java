package com.wesker926.leetcode.algorithms.p0749.s1;

import java.util.*;

/**
 * @author wesker.gh
 * @date 2022/7/18
 * @description DFS标记
 * 这题就是细节比较多
 * 注：每轮选出要隔离的区块后，需要全部复原重新划分区块。
 */
public class Solution {

    private static final int[][] DIRS = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int containVirus(int[][] isInfected) {
        int m = isInfected.length, n = isInfected[0].length, seq = 1;
        List<Set<Integer>> neighbors = new ArrayList<>();
        List<Integer> counts = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isInfected[i][j] == 1) {
                    neighbors.add(new HashSet<>());
                    mark(isInfected, seq, i, j, neighbors);
                    counts.add(computeCount(isInfected, neighbors.get(seq - 1), seq));
                    seq++;
                }
            }
        }

        if (neighbors.isEmpty()) {
            return 0;
        }
        if (neighbors.size() == 1) {
            return counts.get(0);
        }

        int maxIdx = 0;
        for (int i = 1; i < counts.size(); i++) {
            if (neighbors.get(i).size() > neighbors.get(maxIdx).size()) {
                maxIdx = i;
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isInfected[i][j] == -maxIdx - 1) {
                    isInfected[i][j] = 2;
                } else if (isInfected[i][j] < 0) {
                    isInfected[i][j] = 1;
                }
            }
        }
        for (int i = 0; i < neighbors.size(); i++) {
            if (i != maxIdx) {
                for (int pos : neighbors.get(i)) {
                    isInfected[pos >> 7][pos & ((1 << 7) - 1)] = 1;
                }
            }
        }
        return counts.get(maxIdx) + containVirus(isInfected);
    }

    private void mark(int[][] grid, int seq, int x, int y, List<Set<Integer>> neighbors) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) {
            return;
        }
        if (grid[x][y] != 1) {
            if (grid[x][y] == 0) {
                neighbors.get(seq - 1).add((x << 7) | y);
            }
            return;
        }

        grid[x][y] = -seq;
        for (int[] dir : DIRS) {
            mark(grid, seq, x + dir[0], y + dir[1], neighbors);
        }
    }

    private int computeCount(int[][] grid, Set<Integer> neighbor, int seq) {
        int count = 0;
        for (int pos : neighbor) {
            int x = pos >> 7, y = pos & ((1 << 7) - 1);
            for (int[] dir : DIRS) {
                int nx = x + dir[0], ny = y + dir[1];
                if (nx >= 0 && nx < grid.length && ny >= 0 && ny < grid[0].length && grid[nx][ny] == -seq) {
                    count++;
                }
            }
        }
        return count;
    }
}
