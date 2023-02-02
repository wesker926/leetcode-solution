package com.wesker926.leetcode.algorithms.p1129.s1;

import java.util.*;

/**
 * @author wesker.gh
 * @date 2023/2/2
 * @description BFS
 * 注意是有向图，且存在[0,0]自环
 */
public class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        int[][] head = new int[2][n], next = new int[2][], edge = new int[2][];
        int[][][] origins = new int[][][]{redEdges, blueEdges};
        for (int t = 0; t < origins.length; t++) {
            next[t] = new int[origins[t].length * 2];
            edge[t] = new int[origins[t].length * 2];
            Arrays.fill(head[t], -1);
            for (int i = 0, idx = 0; i < origins[t].length; i++) {
                next[t][idx] = head[t][origins[t][i][0]];
                head[t][origins[t][i][0]] = idx;
                edge[t][idx++] = origins[t][i][1];
            }
        }

        int[][] distance = new int[n][2];
        for (int i = 1; i < distance.length; i++) {
            Arrays.fill(distance[i], -1);
        }

        Queue<int[]> queue = new LinkedList<>();
        for (int t = 0; t < head.length; t++) {
            for (int i = head[t][0]; i >= 0; i = next[t][i]) {
                if (distance[edge[t][i]][t] == -1) {
                    distance[edge[t][i]][t] = 1;
                    queue.offer(new int[]{edge[t][i], t, 1});
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curP = cur[0], curV = cur[2], nxtT = 1 - cur[1];
            for (int i = head[nxtT][curP]; i >= 0; i = next[nxtT][i]) {
                int nxtP = edge[nxtT][i];
                if (distance[nxtP][nxtT] >= 0) {
                    continue;
                }
                distance[nxtP][nxtT] = curV + 1;
                queue.offer(new int[]{nxtP, nxtT, curV + 1});
            }
        }

        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int r = distance[i][0], b = distance[i][1];
            ans[i] = r * b < 0 ? Math.max(r, b) : Math.min(r, b);
        }
        return ans;
    }
}
