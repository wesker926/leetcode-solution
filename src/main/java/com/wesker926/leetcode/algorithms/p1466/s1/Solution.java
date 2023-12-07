package com.wesker926.leetcode.algorithms.p1466.s1;

import java.util.Arrays;

/**
 * @author wesker.gh
 * @date 2023/12/7
 * @description DFS
 */
public class Solution {

    int[] head, next, edge, weight;

    public int minReorder(int n, int[][] connections) {
        int idx = 0;
        head = new int[n];
        next = new int[connections.length * 2];
        edge = new int[next.length];
        weight = new int[next.length];
        Arrays.fill(head, -1);
        for (int[] c : connections) {
            for (int i = 0; i < 2; i++) {
                next[idx] = head[c[i]];
                head[c[i]] = idx;
                edge[idx] = c[1 - i];
                weight[idx++] = 1 - i;
            }
        }
        return dfs(0, -1);
    }

    private int dfs(int node, int parent) {
        int res = 0;
        for (int i = head[node]; i >= 0; i = next[i]) {
            if (edge[i] == parent) continue;
            res += weight[i] + dfs(edge[i], node);
        }
        return res;
    }
}
