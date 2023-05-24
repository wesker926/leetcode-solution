package com.wesker926.leetcode.algorithms.p1377.s1;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author wesker.gh
 * @date 2023/5/24
 * @description BFS
 * 无环图，只有一条路
 */
public class Solution {
    public double frogPosition(int n, int[][] edges, int t, int target) {
        int[] head = new int[n + 1], count = new int[n + 1];
        int[] next = new int[edges.length * 2], edge = new int[edges.length * 2];
        Arrays.fill(head, -1);
        count[1]++;
        for (int i = 0, idx = 0; i < edges.length; i++) {
            for (int j = 0; j <= 1; j++) {
                next[idx] = head[edges[i][j]];
                head[edges[i][j]] = idx;
                edge[idx++] = edges[i][1 - j];
                count[edges[i][j]]++;
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{1, 0, 1, 0}); // cur pre score time
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            if (cur[3] > t) break;
            if (cur[0] == target) return count[target] == 1 || cur[3] == t ? 1 / (double) cur[2] : 0;
            for (int i = head[cur[0]]; i >= 0; i = next[i]) {
                int nxt = edge[i];
                if (nxt == cur[1]) continue;
                queue.offer(new int[]{nxt, cur[0], cur[2] * (count[cur[0]] - 1), cur[3] + 1});
            }
        }
        return 0;
    }
}
