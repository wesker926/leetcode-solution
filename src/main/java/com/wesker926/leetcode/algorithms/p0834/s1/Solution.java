package com.wesker926.leetcode.algorithms.p0834.s1;

import java.util.Arrays;

/**
 * @author wesker.gh
 * @date 2023/7/16
 * @description DFS 记忆化搜索
 * 其实是换根（树形）DP板子题，标准答案参考下这个 https://oi-wiki.org/dp/tree/
 */
public class Solution {

    private int[] head, next, edge;

    private int[][] w;

    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        if (n == 1) return new int[1];
        head = new int[n];
        Arrays.fill(head, -1);
        next = new int[n * 2 - 2];
        edge = new int[n * 2 - 2];
        w = new int[n * 2 - 2][2];
        for (int i = 0, idx = 0; i < n - 1; i++) {
            for (int j = 0; j < 2; j++) {
                next[idx] = head[edges[i][j]];
                head[edges[i][j]] = idx;
                edge[idx++] = edges[i][1 - j];
            }
        }

        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        for (int i = 0; i < edges.length; i++) {
            for (int j = 0; j < 2; j++) {
                int p1 = edges[i][j], p2 = edges[i][1 - j], e1 = i * 2 + j, e2 = i * 2 + 1 - j;
                if (w[e1][1] != 0) continue;
                if (ans[p2] >= 0) {
                    w[e1][0] = ans[p2] - w[e2][0] - w[e2][1];
                    w[e1][1] = n - w[e2][1];
                    continue;
                }
                dfs(p1, p2, e1);
            }
            for (int j = 0; j < 2; j++) {
                int p1 = edges[i][j], e1 = i * 2 + j, e2 = i * 2 + 1 - j;
                if (ans[p1] >= 0) continue;
                ans[p1] = w[e1][0] + w[e1][1] + w[e2][0];
            }
        }

        return ans;
    }

    private void dfs(int pre, int cur, int e) {
        if (w[e][1] != 0) return;
        for (int i = head[cur]; i >= 0; i = next[i]) {
            if (edge[i] == pre) continue;
            dfs(cur, edge[i], i);
            w[e][0] += w[i][0];
            w[e][1] += w[i][1];
        }
        w[e][0] += w[e][1];
        w[e][1]++;
    }
}
