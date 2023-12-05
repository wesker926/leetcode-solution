package com.wesker926.leetcode.algorithms.p2477.s1;

import java.util.Arrays;

/**
 * @author wesker.gh
 * @date 2023/12/5
 * @description DFS
 * 统计每层的代价
 * 来到本层的人可以拼车，只用最少的车（上取整）
 */
public class Solution {

    private static int[] head, next, edge;

    public long minimumFuelCost(int[][] roads, int seats) {
        int n = roads.length + 1, idx = 0;
        head = new int[n];
        next = new int[2 * n - 2];
        edge = new int[2 * n - 2];
        Arrays.fill(head, -1);
        for (int[] road : roads) {
            for (int i = 0; i < 2; i++) {
                next[idx] = head[road[i]];
                head[road[i]] = idx;
                edge[idx++] = road[1 - i];
            }
        }
        return dfs(-1, 0, seats)[0];
    }

    private long[] dfs(int pre, int cur, int seats) {
        long[] res = new long[]{0, 1};
        if (cur != 0 && next[head[cur]] < 0) return res;
        for (int i = head[cur]; i >= 0; i = next[i]) {
            if (edge[i] == pre) continue;
            long[] nxt = dfs(cur, edge[i], seats);
            res[0] += nxt[0] + (nxt[1] - 1) / seats + 1;
            res[1] += nxt[1];
        }
        return res;
    }
}
