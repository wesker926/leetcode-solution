package com.wesker926.leetcode.algorithms.p0399.s2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wesker.gh
 * @date 2022/6/21
 * @description 带权并查集
 */
public class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Integer> seq = new HashMap<>();
        UnionFind set = new UnionFind(equations.size() * 2);
        for (int idx = 0, i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            if (!seq.containsKey(equation.get(0))) {
                seq.put(equation.get(0), idx++);
            }
            if (!seq.containsKey(equation.get(1))) {
                seq.put(equation.get(1), idx++);
            }
            set.union(seq.get(equation.get(0)), seq.get(equation.get(1)), values[i]);
        }
        double[] ans = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            int x = seq.getOrDefault(queries.get(i).get(0), -1);
            int y = seq.getOrDefault(queries.get(i).get(1), -1);
            ans[i] = x == -1 || y == -1 ? -1 : set.getWeight(x, y);
        }
        return ans;
    }

    // 并查集
    private static class UnionFind {

        private final int[] parent;

        private final double[] weight;

        public UnionFind(int n) {
            parent = new int[n];
            weight = new double[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                weight[i] = 1;
            }
        }

        public void union(int x, int y, double w) {
            int px = find(x), py = find(y);
            if (px == py) {
                return;
            }
            parent[px] = py;
            weight[px] = w * weight[y] / weight[x];
        }

        public int find(int c) {
            if (parent[c] != c) {
                int op = parent[c];
                parent[c] = find(op);
                weight[c] *= weight[op];
            }
            return parent[c];
        }

        public double getWeight(int x, int y) {
            int px = find(x), py = find(y);
            return px != py ? -1 : weight[x] / weight[y];
        }
    }
}
