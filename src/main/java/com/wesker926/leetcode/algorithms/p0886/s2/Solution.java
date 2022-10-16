package com.wesker926.leetcode.algorithms.p0886.s2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wesker.gh
 * @date 2022/10/16
 * @description 并查集
 * 普通并查集：将i不喜欢的数合并，然后检查i是否和不喜欢的数连接
 */
public class Solution {
    @SuppressWarnings("all")
    public boolean possibleBipartition(int n, int[][] dislikes) {
        Union u = new Union(n);
        List<Integer>[] graph = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] dislike : dislikes) {
            graph[dislike[0]].add(dislike[1]);
            graph[dislike[1]].add(dislike[0]);
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < graph[i].size(); j++) {
                u.union(graph[i].get(0), graph[i].get(j));
                if (u.isConnect(i, graph[i].get(j))) {
                    return false;
                }
            }
        }
        return true;
    }

    private static class Union {

        private final int[] parent;

        Union(int n) {
            parent = new int[n + 1];
            for (int i = 0; i <= n; i++) {
                parent[i] = i;
            }
        }

        public void union(int i, int j) {
            parent[find(j)] = find(i);
        }

        public boolean isConnect(int i, int j) {
            return find(i) == find(j);
        }

        public int find(int i) {
            return parent[i] != i ? (parent[i] = find(parent[i])) : i;
        }
    }
}
