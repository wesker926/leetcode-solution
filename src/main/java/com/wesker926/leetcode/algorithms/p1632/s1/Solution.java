package com.wesker926.leetcode.algorithms.p1632.s1;

import java.util.*;

/**
 * @author wesker.gh
 * @date 2023/1/25
 * @description 并查集 + 邻接表 + 拓扑排序
 * 并查集可以减少图的复杂性，但不用并查集也可以解
 */
public class Solution {
    public int[][] matrixRankTransform(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length, len = m * n;
        Union union = new Union(len);
        for (int t = 0; t < 2; t++) {
            int x = t == 0 ? m : n, y = t == 0 ? n : m;
            for (int i = 0; i < x; i++) {
                Map<Integer, List<Integer>> map = new HashMap<>();
                for (int j = 0; j < y; j++) {
                    int key = t == 0 ? matrix[i][j] : matrix[j][i];
                    int code = t == 0 ? encode(i, j, y) : encode(j, i, x);
                    map.computeIfAbsent(key, k -> new ArrayList<>()).add(code);
                }
                for (List<Integer> idxList : map.values()) {
                    for (int k = 1; k < idxList.size(); k++) {
                        union.union(idxList.get(0), idxList.get(k));
                    }
                }
            }
        }

        int idx = 0;
        int[] degree = new int[len], head = new int[len], next = new int[len * 2], edge = new int[len * 2];
        Arrays.fill(head, -1);
        for (int t = 0; t < 2; t++) {
            int x = t == 0 ? m : n, y = t == 0 ? n : m;
            for (int i = 0; i < x; i++) {
                Map<Integer, Integer> map = new HashMap<>();
                for (int j = 0; j < y; j++) {
                    int key = t == 0 ? matrix[i][j] : matrix[j][i];
                    map.putIfAbsent(key, t == 0 ? encode(i, j, y) : encode(j, i, x));
                }
                List<Integer> arr = new ArrayList<>(map.keySet());
                Collections.sort(arr);
                for (int k = 1; k < arr.size(); k++) {
                    int pre = union.find(map.get(arr.get(k - 1))), cur = union.find(map.get(arr.get(k)));
                    next[idx] = head[pre];
                    head[pre] = idx;
                    edge[idx++] = cur;
                    degree[cur]++;
                }
            }
        }

        List<Integer> roots = union.root();
        Queue<Integer> queue = new LinkedList<>();
        for (int root : roots) {
            if (degree[root] == 0) {
                queue.offer(root);
            }
        }

        int[][] res = new int[m][n];
        int level = queue.size(), rank = 1;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            int[] pos = decode(cur, n);
            res[pos[0]][pos[1]] = rank;
            for (int i = head[cur]; i >= 0; i = next[i]) {
                if (--degree[edge[i]] == 0) {
                    queue.offer(edge[i]);
                }
            }
            if (--level == 0) {
                level = queue.size();
                rank++;
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (res[i][j] == 0) {
                    int[] parent = decode(union.find(encode(i, j, n)), n);
                    res[i][j] = res[parent[0]][parent[1]];
                }
            }
        }
        return res;
    }

    private int encode(int i, int j, int n) {
        return i * n + j;
    }

    private int[] decode(int code, int n) {
        return new int[]{code / n, code % n};
    }

    private static class Union {

        int[] parent;

        Union(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        void union(int i, int j) {
            parent[find(j)] = find(i);
        }

        int find(int i) {
            return parent[i] != i ? (parent[i] = find(parent[i])) : i;
        }

        List<Integer> root() {
            List<Integer> res = new ArrayList<>();
            for (int i = 0; i < parent.length; i++) {
                if (parent[i] == i) {
                    res.add(i);
                }
            }
            return res;
        }
    }
}
