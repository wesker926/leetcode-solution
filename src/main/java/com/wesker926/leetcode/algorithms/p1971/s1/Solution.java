package com.wesker926.leetcode.algorithms.p1971.s1;

/**
 * @author wesker.gh
 * @date 2022/12/19
 * @description 并查集
 * 可用BFS，DFS，并查集来解决
 */
public class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Union set = new Union(n);
        for (int[] edge : edges) {
            set.union(edge[0], edge[1]);
            if (set.isConnect(source, destination)) {
                return true;
            }
        }
        return set.isConnect(source, destination);
    }

    private static class Union {

        private final int[] parent;

        Union(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        void union(int i, int j) {
            parent[find(j)] = find(i);
        }

        boolean isConnect(int i, int j) {
            return find(i) == find(j);
        }

        int find(int i) {
            return parent[i] != i ? (parent[i] = find(parent[i])) : i;
        }
    }
}
