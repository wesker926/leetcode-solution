package com.wesker926.leetcode.algorithms.p1000.s2;

import java.util.Arrays;

/**
 * @author wesker.gh
 * @date 2023/4/4
 * @description 区间DP
 * 三维DP，三维分别是[st，ed，合并的堆数]
 */
public class Solution {

    private static final int INF = 0x3f3f3f3f;

    public int mergeStones(int[] stones, int k) {
        int n = stones.length;
        if ((n - 1) % (k - 1) != 0) {
            return -1;
        }
        int[][][] dp = new int[n][n][k + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dp[i][j], INF);
            }
        }
        int[] pre = new int[n + 1];
        for (int i = 0; i < n; i++) {
            dp[i][i][1] = 0;
            pre[i + 1] = pre[i] + stones[i];
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                for (int t = 2; t <= k; t++) {
                    for (int l = i; l < j; l += k - 1) {
                        dp[i][j][t] = Math.min(dp[i][j][t], dp[i][l][1] + dp[l + 1][j][t - 1]);
                    }
                }
                dp[i][j][1] = Math.min(dp[i][j][1], dp[i][j][k] + pre[j + 1] - pre[i]);
            }
        }
        return dp[0][n - 1][1];
    }
}
