package com.wesker926.leetcode.algorithms.p0753.s1;

/**
 * @author wesker.gh
 * @date 2023/1/10
 * @description DFS
 * 欧拉回路 - Hierholzer算法
 * 注：同汉密尔顿回路不同
 */
public class Solution {
    public String crackSafe(int n, int k) {
        boolean[] visited = new boolean[10000];
        StringBuilder sb = new StringBuilder();
        dfs(0, k, (int) Math.pow(10, n - 1), visited, sb);
        return sb.append("0".repeat(n - 1)).toString();
    }

    private void dfs(int cur, int k, int mask, boolean[] visited, StringBuilder sb) {
        for (int i = 0; i < k; i++) {
            int nxt = cur * 10 + i;
            if (visited[nxt]) {
                continue;
            }
            visited[nxt] = true;
            dfs(nxt % mask, k, mask, visited, sb);
            sb.append(i);
        }
    }
}
