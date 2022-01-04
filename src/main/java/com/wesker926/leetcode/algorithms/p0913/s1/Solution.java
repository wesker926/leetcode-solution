package com.wesker926.leetcode.algorithms.p0913.s1;

import java.util.Arrays;

/**
 * @author wesker.gh
 * @date 2022/1/4
 * @description 博弈 + 自顶向下的动态规划（记忆化搜索）
 */
public class Solution {

    private int n;

    private int[][] graph;

    private int[][][] dp;

    public int catMouseGame(int[][] graph) {
        this.graph = graph;
        this.n = graph.length;
        this.dp = new int[n][n][n * 2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        return dfs(1, 2, 0);
    }

    private int dfs(int i, int j, int k) {
        if (k == n * 2) {
            return 0;
        }

        if (dp[i][j][k] != -1) {
            return dp[i][j][k];
        }

        if (i == 0) {
            dp[i][j][k] = 1;
        } else if (j == i) {
            dp[i][j][k] = 2;
        } else {
            int nxtMove = (k & 1) == 0 ? i : j, defaultRes = nxtMove == i ? 2 : 1, nxt;
            dp[i][j][k] = defaultRes;
            for (int node : graph[nxtMove]) {
                if (nxtMove == j && node == 0) {
                    continue;
                }
                nxt = dfs(nxtMove == i ? node : i, nxtMove == j ? node : j, k + 1);
                if (nxt != defaultRes) {
                    dp[i][j][k] = nxt;
                    if (nxt != 0) {
                        break;
                    }
                }
            }
        }
        return dp[i][j][k];
    }
}
