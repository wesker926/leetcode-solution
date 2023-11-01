package com.wesker926.leetcode.algorithms.p2127.s1;

import java.util.Arrays;

/**
 * @author wesker.gh
 * @date 2023/11/1
 * @description DFS + 拓扑排序
 * https://leetcode.cn/problems/maximum-employees-to-be-invited-to-a-meeting/solutions/1190222/can-jia-hui-yi-de-zui-duo-yuan-gong-shu-u8e8u/?envType=daily-question&envId=2023-11-01
 */
public class Solution {

    private int maxRing, maxChain;

    private int[] next, head, pre, edge;

    public int maximumInvitations(int[] favorite) {
        maxRing = maxChain = 0;
        int n = favorite.length, idx = 0;
        next = favorite;
        head = new int[n];
        pre = new int[n];
        edge = new int[n];
        Arrays.fill(head, -1);
        for (int i = 0; i < next.length; i++) {
            pre[idx] = head[next[i]];
            head[next[i]] = idx;
            edge[idx++] = i;
        }

        long[] visited = new long[n];
        for (int i = 0; i < n; i++) {
            if (visited[i] != 0) continue;
            findRing(i, (i << 17) + 1, visited);
        }
        return Math.max(maxRing, maxChain);
    }

    private void findRing(int node, int cnt, long[] v) {
        if (v[node] != 0) {
            if ((v[node] >> 17) != (cnt >> 17)) return;
            int res = (int) (cnt - v[node]);
            if (res != 2) maxRing = Math.max(maxRing, res);
            else maxChain += res + findChain(node, next[node], 0) +
                    findChain(next[node], node, 0);
            return;
        }
        v[node] = cnt;
        findRing(next[node], cnt + 1, v);
    }

    private int findChain(int ignore, int cur, int cnt) {
        int max = cnt;
        for (int i = head[cur]; i >= 0; i = pre[i]) {
            if (edge[i] == ignore) continue;
            max = Math.max(max, findChain(ignore, edge[i], cnt + 1));
        }
        return max;
    }
}
