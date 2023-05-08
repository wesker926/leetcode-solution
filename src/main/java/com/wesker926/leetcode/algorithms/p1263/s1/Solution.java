package com.wesker926.leetcode.algorithms.p1263.s1;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author wesker.gh
 * @date 2023/5/8
 * @description BFS + 堆
 * 堆耗时严重，可优化
 */
public class Solution {

    private static final int[][] DIRS = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    @SuppressWarnings("all")
    public int minPushBox(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] init = getFirst(grid);
        boolean[] visited = new boolean[160000];
        Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(p -> p[4]));
        queue.offer(new int[]{init[0], init[1], init[2], init[3], 0});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int code = encode(cur);
            if (visited[code]) continue;
            visited[code] = true;
            if (cur[2] == init[4] && cur[3] == init[5]) return cur[4];
            for (int[] dir : DIRS) {
                int[] nxt = new int[]{cur[0] + dir[0], cur[1] + dir[1], cur[2], cur[3], cur[4]};
                if (nxt[0] == nxt[2] && nxt[1] == nxt[3]) {
                    nxt[2] += dir[0];
                    nxt[3] += dir[1];
                    nxt[4]++;
                }
                if (nxt[0] < 0 || nxt[0] >= m || nxt[1] < 0 || nxt[1] >= n ||
                        nxt[2] < 0 || nxt[2] >= m || nxt[3] < 0 || nxt[3] >= n ||
                        grid[nxt[0]][nxt[1]] == '#' || grid[nxt[2]][nxt[3]] == '#' || visited[encode(nxt)]) continue;
                queue.offer(nxt);
            }
        }
        return -1;
    }

    private int[] getFirst(char[][] grid) {
        int[] first = new int[6];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                char ch = grid[i][j];
                if (!Character.isLetter(ch)) continue;
                int idx = ch == 'S' ? 0 : (ch == 'B' ? 2 : 4);
                first[idx] = i;
                first[idx + 1] = j;
            }
        }
        return first;
    }

    private int encode(int[] pos) {
        return pos[0] * 8000 + pos[1] * 400 + pos[2] * 20 + pos[3];
    }
}
