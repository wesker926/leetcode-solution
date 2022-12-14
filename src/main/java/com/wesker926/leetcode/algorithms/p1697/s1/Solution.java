package com.wesker926.leetcode.algorithms.p1697.s1;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author wesker.gh
 * @date 2022/12/14
 * @description 并查集 + 离线查询
 * 本题是需要求取两点的受限连通情况，把带权无向图转换为连通块，因此可以使用并查集
 * 每个查询的限制不同，但是如果对限制按由严格到宽松排序，那么后面的查询可以正常使用前面查询构造的连通块，因此可以使用离线查询
 * 离线查询是指对于请求不是一个个去查询返回，而是一批一起查询。比如本题，一批一起查询只需要逐渐构建一个并查集
 */
public class Solution {
    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        Arrays.sort(edgeList, Comparator.comparingInt(a -> a[2]));
        Integer[] idxs = new Integer[queries.length];
        for (int i = 0; i < queries.length; i++) {
            idxs[i] = i;
        }
        Arrays.sort(idxs, Comparator.comparingInt(i -> queries[i][2]));
        Union set = new Union(n);
        boolean[] ans = new boolean[queries.length];
        for (int i = 0, j = 0; i < idxs.length; i++) {
            for (; j < edgeList.length && edgeList[j][2] < queries[idxs[i]][2]; j++) {
                set.union(edgeList[j][0], edgeList[j][1]);
            }
            ans[idxs[i]] = set.isConnect(queries[idxs[i]][0], queries[idxs[i]][1]);
        }
        return ans;
    }

    private static class Union {

        private final int[] parent;

        Union(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
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
