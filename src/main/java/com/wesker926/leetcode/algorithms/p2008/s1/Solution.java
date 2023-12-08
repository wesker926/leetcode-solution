package com.wesker926.leetcode.algorithms.p2008.s1;

import java.util.Arrays;

/**
 * @author wesker.gh
 * @date 2023/12/8
 * @description DP
 * 记忆化搜索也可以，但是没DP快
 */
public class Solution {
    public long maxTaxiEarnings(int n, int[][] rides) {
        int idx = 0, m = rides.length;
        long[] dp = new long[n + 1];
        int[] head = new int[n + 1], next = new int[m];
        int[] edge = new int[m], weight = new int[m];
        Arrays.fill(head, -1);
        Arrays.fill(dp, -1);
        dp[n] = 0;
        for (int[] ride : rides) {
            next[idx] = head[ride[0]];
            head[ride[0]] = idx;
            edge[idx] = ride[1];
            weight[idx++] = ride[2];
        }

        long nxtMax = dp[n];
        for (int i = n - 1, j; i >= 0; nxtMax = Math.max(nxtMax, dp[i--])) {
            for (dp[i] = nxtMax, j = head[i]; j >= 0; j = next[j]) {
                dp[i] = Math.max(dp[i], dp[edge[j]] + edge[j] - i + weight[j]);
            }
        }
        return dp[0];
    }
}
