package com.wesker926.leetcode.algorithms.p1617.s1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wesker.gh
 * @date 2023/3/12
 * @description 枚举所有子树
 * 通过DFS检查子树连通性和计算其直径
 */
public class Solution {
    @SuppressWarnings("unchecked")
    public int[] countSubgraphsForEachDiameter(int n, int[][] edges) {
        List<Integer>[] adj = new List[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            adj[edge[0] - 1].add(edge[1] - 1);
            adj[edge[1] - 1].add(edge[0] - 1);
        }
        int[] ans = new int[n - 1], dfsRes = new int[2];
        for (int i = 1; i < (1 << n); i++) {
            int root = 32 - Integer.numberOfLeadingZeros(i) - 1;
            dfsRes[0] = i;
            dfsRes[1] = 0;
            dfs(root, adj, dfsRes);
            if (dfsRes[0] == 0 && dfsRes[1] > 0) {
                ans[dfsRes[1] - 1]++;
            }
        }
        return ans;
    }

    private int dfs(int root, List<Integer>[] adj, int[] res) {
        res[0] &= ~(1 << root);
        int first = 0, second = 0;
        for (int nxt : adj[root]) {
            if ((res[0] & (1 << nxt)) == 0) {
                continue;
            }
            int distance = 1 + dfs(nxt, adj, res);
            if (distance > first) {
                second = first;
                first = distance;
            } else if (distance > second) {
                second = distance;
            }
        }
        res[1] = Math.max(res[1], first + second);
        return first;
    }
}
