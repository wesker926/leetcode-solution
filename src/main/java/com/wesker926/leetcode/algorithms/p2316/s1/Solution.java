package com.wesker926.leetcode.algorithms.p2316.s1;

/**
 * @author wesker.gh
 * @date 2023/10/21
 * @description 并查集
 */
public class Solution {
    public long countPairs(int n, int[][] edges) {
        Union u = new Union(n);
        for (int[] edge : edges) u.union(edge[0], edge[1]);
        int[] cnt = new int[n];
        for (int i = 0; i < n; i++) cnt[u.find(i)]++;
        long ans = 0;
        for (int i = 0; i < n; i++) ans += (long) cnt[i] * (n - cnt[i]);
        return ans >> 1;
    }

    private static class Union {

        int[] parent;

        Union(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
        }

        void union(int i, int j) {
            parent[find(i)] = find(j);
        }

        int find(int i) {
            return parent[i] != i ? (parent[i] = find(parent[i])) : i;
        }
    }
}
