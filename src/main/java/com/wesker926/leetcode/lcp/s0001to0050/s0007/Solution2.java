package com.wesker926.leetcode.lcp.s0001to0050.s0007;

/**
 * @author wesker
 * @date 2021/7/1
 * @description LCP 07. 传递信息
 */
public class Solution2 {
    /**
     * DFS
     */
    public int numWays(int n, int[][] relation, int k) {
        boolean[][] graph = new boolean[n][n];
        for (int[] r : relation) {
            graph[r[0]][r[1]] = true;
        }
        return dfs(0, k, graph);
    }

    private int dfs(int i, int k, boolean[][] graph) {
        if (k == 0) {
            return i == graph.length - 1 ? 1 : 0;
        }
        int sum = 0;
        for (int j = 0; j < graph.length; j++) {
            if (graph[i][j]) {
                sum += dfs(j, k - 1, graph);
            }
        }
        return sum;
    }
}
