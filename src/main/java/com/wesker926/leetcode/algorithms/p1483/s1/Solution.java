package com.wesker926.leetcode.algorithms.p1483.s1;

import java.util.Arrays;

/**
 * @author wesker.gh
 * @date 2023/6/12
 * @description 树上倍增法
 * LCA（最近公共祖先）模版算法
 */
public class Solution {

    private final int[][] dp;

    /**
     * Your TreeAncestor object will be instantiated and called as such:
     * TreeAncestor obj = new TreeAncestor(n, parent);
     * int param_1 = obj.getKthAncestor(node,k);
     */
    public Solution(int n, int[] parent) {
        int log = 16;
        dp = new int[n][log];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
            dp[i][0] = parent[i];
        }
        for (int j = 1; j < log; j++)
            for (int i = 0; i < n; i++)
                if (dp[i][j - 1] != -1) dp[i][j] = dp[dp[i][j - 1]][j - 1];
    }

    public int getKthAncestor(int node, int k) {
        for (int j = 0; k > 0 && node >= 0; j++, k >>= 1) if ((k & 1) != 0) node = dp[node][j];
        return node;
    }
}
