package com.wesker926.leetcode.algorithms.p1631.s1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author wesker.gh
 * @date 2023/12/11
 * @description 最短路径
 * 高度差绝对值满足交换律和结合律，可以用Dijkstra算法
 * https://leetcode.cn/problems/path-with-minimum-effort/solutions/581109/zui-xiao-ti-li-xiao-hao-lu-jing-by-leetc-3q2j/?envType=daily-question&envId=2023-12-11
 */
public class Solution {

    private static final int[][] DIRS = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int minimumEffortPath(int[][] h) {
        int m = h.length, n = h[0].length;
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(e -> e[2]));
        queue.offer(new int[]{0, 0, 0});
        int[] d = new int[m * n];
        Arrays.fill(d, Integer.MAX_VALUE);
        boolean[] v = new boolean[m * n];
        for (d[0] = 0; !queue.isEmpty(); ) {
            int[] cur = queue.poll();
            if (cur[0] == m - 1 && cur[1] == n - 1) break;
            int id = cur[0] * n + cur[1];
            if (v[id]) continue;
            v[id] = true;
            for (int[] dir : DIRS) {
                int nx = cur[0] + dir[0], ny = cur[1] + dir[1];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
                int nd = Math.max(cur[2], Math.abs(h[cur[0]][cur[1]] - h[nx][ny]));
                if (nd < d[nx * n + ny]) queue.offer(new int[]{nx, ny, d[nx * n + ny] = nd});
            }
        }
        return d[m * n - 1];
    }
}
