package com.wesker926.leetcode.algorithms.p2039.s1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author wesker.gh
 * @date 2022/3/20
 * @description 邻接表 + 最小堆优化的迪杰斯特拉
 */
public class Solution {

    private static final int N = 100010, M = N * 2, INF = Integer.MAX_VALUE >> 1;

    private static final int[] HEAD = new int[N], NEXT = new int[M], EDGE = new int[M], WEIGHT = new int[M];

    private static final int[] DIST = new int[N];

    private static final boolean[] VISIT = new boolean[N];

    public int networkBecomesIdle(int[][] edges, int[] patience) {
        int n = patience.length, idx = 0;
        Arrays.fill(HEAD, -1);
        Arrays.fill(DIST, INF);
        Arrays.fill(VISIT, false);

        for (int[] e : edges) {
            add(e[0], e[1], 1, idx++);
            add(e[1], e[0], 1, idx++);
        }

        DIST[0] = 0;
        Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        queue.offer(new int[]{0, 0});
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            if (VISIT[cur[0]]) {
                continue;
            }

            VISIT[cur[0]] = true;
            for (int i = HEAD[cur[0]]; i != -1; i = NEXT[i]) {
                int nxt = EDGE[i];
                int w = WEIGHT[i];
                if (DIST[nxt] > DIST[cur[0]] + w) {
                    DIST[nxt] = DIST[cur[0]] + w;
                    queue.offer(new int[]{nxt, DIST[nxt]});
                }
            }
        }

        int max = -1;
        for (int i = 1; i < n; i++) {
            int time = DIST[i] * 2;
            int cur = time * 2 - (time - 1) % patience[i] - 1;
            max = Math.max(max, cur);
        }
        return max + 1;
    }

    private void add(int a, int b, int w, int i) {
        NEXT[i] = HEAD[a];
        HEAD[a] = i;
        EDGE[i] = b;
        WEIGHT[i] = w;
    }
}
