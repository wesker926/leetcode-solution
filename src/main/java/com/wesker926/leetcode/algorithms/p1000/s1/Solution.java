package com.wesker926.leetcode.algorithms.p1000.s1;

import java.util.Arrays;

/**
 * @author wesker.gh
 * @date 2023/4/4
 * @description 区间DP
 * 二维DP，二维分别是[st，ed]
 * 难度很大，参考题解
 */
public class Solution {

    private static final int INF = 0x3f3f3f3f;

    public int mergeStones(int[] stones, int k) {
        int n = stones.length;
        if ((n - 1) % (k - 1) != 0) {
            return -1;
        }
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], INF);
        }
        int[] pre = new int[n + 1];
        for (int i = 0; i < n; i++) {
            dp[i][i] = 0;
            pre[i + 1] = pre[i] + stones[i];
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                for (int l = i; l < j; l += k - 1) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][l] + dp[l + 1][j]);
                }
                if ((j - i) % (k - 1) == 0) {
                    dp[i][j] += pre[j + 1] - pre[i];
                }
            }
        }
        return dp[0][n - 1];
    }
}
