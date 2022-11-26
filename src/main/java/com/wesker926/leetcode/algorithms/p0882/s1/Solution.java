package com.wesker926.leetcode.algorithms.p0882.s1;

import java.util.*;

/**
 * @author wesker.gh
 * @date 2022/11/26
 * @description Dijkstra算法
 * 迪科斯特拉单源最短路径变种题
 */
public class Solution {
    public int reachableNodes(int[][] edges, int maxMoves, int n) {
        int[] he = new int[n], ne = new int[edges.length * 2];
        int[][] ew = new int[edges.length * 2][2];
        Arrays.fill(he, -1);
        for (int i = 0; i < edges.length; i++) {
            for (int j = 0, k = i * 2; j < 2; j++) {
                ne[k + j] = he[edges[i][j]];
                ew[k + j][0] = edges[i][1 - j];
                ew[k + j][1] = edges[i][2];
                he[edges[i][j]] = k + j;
            }
        }

        int ans = 0;
        boolean[] visited = new boolean[n];
        Map<Integer, Integer> canReach = new HashMap<>();
        Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        queue.offer(new int[]{0, 0});
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            if (visited[cur[0]]) {
                continue;
            }
            visited[cur[0]] = true;
            ans++;
            for (int i = he[cur[0]]; i >= 0; i = ne[i]) {
                int[] nxt = ew[i];
                if (!visited[nxt[0]] && cur[1] + nxt[1] + 1 <= maxMoves) {
                    queue.offer(new int[]{nxt[0], cur[1] + nxt[1] + 1});
                }
                canReach.put(encode(n, cur[0], nxt[0]), Math.min(maxMoves - cur[1], nxt[1]));
            }
        }

        for (int[] edge : edges) {
            ans += Math.min(canReach.getOrDefault(encode(n, edge[0], edge[1]), 0) +
                    canReach.getOrDefault(encode(n, edge[1], edge[0]), 0), edge[2]);
        }
        return ans;
    }

    private int encode(int n, int u, int v) {
        return n * u + v;
    }
}
