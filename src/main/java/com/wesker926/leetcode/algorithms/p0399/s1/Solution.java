package com.wesker926.leetcode.algorithms.p0399.s1;

import java.util.*;

/**
 * @author wesker.gh
 * @date 2022/6/21
 * @description 有向图DFS
 */
public class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, List<Pair>> table = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            double val = values[i];
            List<Pair> cur = table.computeIfAbsent(equation.get(0), k -> new ArrayList<>());
            cur.add(new Pair(equation.get(1), val));
            cur = table.computeIfAbsent(equation.get(1), k -> new ArrayList<>());
            cur.add(new Pair(equation.get(0), 1 / val));
        }
        double[] ans = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String from = queries.get(i).get(0), to = queries.get(i).get(1);
            if (!table.containsKey(from) || !table.containsKey(to)) {
                ans[i] = -1;
                continue;
            }
            ans[i] = dfs(table, queries.get(i).get(0), queries.get(i).get(1), 1, new HashSet<>());
        }
        return ans;
    }

    private double dfs(Map<String, List<Pair>> table, String from, String to, double cur, Set<String> used) {
        if (from.equals(to)) {
            return cur;
        }
        if (used.contains(from) || !table.containsKey(from)) {
            return -1;
        }
        used.add(from);
        for (Pair pair : table.get(from)) {
            double nxt = dfs(table, pair.key, to, cur * pair.value, used);
            if (nxt >= 0) {
                return nxt;
            }
        }
        used.remove(from);
        return -1;
    }

    private static class Pair {

        String key;

        Double value;

        Pair(String key, Double value) {
            this.key = key;
            this.value = value;
        }
    }
}
