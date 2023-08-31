package com.wesker926.leetcode.algorithms.p1761.s1;

import java.util.*;

/**
 * @author wesker.gh
 * @date 2023/8/31
 * @description 暴力枚举
 * 枚举点或者枚举边
 * https://leetcode.cn/problems/minimum-degree-of-a-connected-trio-in-a-graph/solutions/2417898/yi-ge-tu-zhong-lian-tong-san-yuan-zu-de-wuv8o/
 */
public class Solution {
    public int minTrioDegree(int n, int[][] edges) {
        boolean[][] graph = new boolean[n + 1][n + 1];
        int[] head = new int[n + 1], next = new int[edges.length], edge = new int[edges.length], degree = new int[n + 1];
        Arrays.fill(head, -1);
        for (int[] e : edges) {
            graph[e[0]][e[1]] = graph[e[1]][e[0]] = true;
            degree[e[0]]++;
            degree[e[1]]++;
        }
        int idx = 0, ans = Integer.MAX_VALUE;
        for (int[] e : edges) {
            int i = degree[e[0]] < degree[e[1]] || (degree[e[0]] == degree[e[1]] && e[0] < e[1]) ? 0 : 1;
            next[idx] = head[e[i]];
            head[e[i]] = idx;
            edge[idx++] = e[1 - i];
        }

        for (int i = 1; i <= n; i++) {
            for (int j = head[i]; j >= 0; j = next[j]) {
                for (int k = head[edge[j]]; k >= 0; k = next[k]) {
                    if (graph[i][edge[k]]) {
                        ans = Math.min(ans, degree[i] + degree[edge[j]] + degree[edge[k]] - 6);
                    }
                }
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
