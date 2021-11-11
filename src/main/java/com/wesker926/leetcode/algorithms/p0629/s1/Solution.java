package com.wesker926.leetcode.algorithms.p0629.s1;

/**
 * @author wesker.gh
 * @date 2021/11/11
 * @description dp
 */
public class Solution {

    private static final int M = 1000000007;

    public int kInversePairs(int n, int k) {
        if (k == 0) {
            return 1;
        }

        int max, cur = 1;
        int[][] dp = new int[2][k + 1];
        dp[0][0] = dp[1][0] = 1;
        for (int i = 2; i <= n; i++) {
            max = Math.min(i * (i - 1) / 2, k);
            for (int j = 1; j <= max; j++) {
                dp[cur][j] = dp[cur][j - 1] + dp[1 - cur][j];
                if (j >= i) {
                    dp[cur][j] -= dp[1 - cur][j - i];
                }
                dp[cur][j] = mod(dp[cur][j]);
            }
            cur = 1 - cur;
        }
        return dp[1 - cur][k];
    }

    private int mod(int i) {
        return i >= M ? i - M : (i < 0 ? i + M : i);
    }
}
