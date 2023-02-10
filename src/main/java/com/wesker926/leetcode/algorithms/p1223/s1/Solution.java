package com.wesker926.leetcode.algorithms.p1223.s1;

/**
 * @author wesker.gh
 * @date 2023/2/10
 * @description DP
 */
public class Solution {

    private static final int MOD = (int) 1e9 + 7;

    public int dieSimulator(int n, int[] rollMax) {
        long sum = 1;
        long[][][] dp = new long[2][6][];
        for (int i = 0; i < 6; i++) {
            dp[0][i] = new long[rollMax[i] + 1];
            dp[1][i] = new long[rollMax[i] + 1];
        }
        for (int t = 0, c = 1; t < n; t++, c = 1 - c) {
            long allSum = 0;
            for (int i = 0; i < 6; i++) {
                dp[c][i][1] = (sum - dp[1 - c][i][0] + MOD) % MOD;
                long rollSum = dp[c][i][1];
                for (int j = 2; j <= rollMax[i]; j++) {
                    dp[c][i][j] = dp[1 - c][i][j - 1];
                    rollSum = (rollSum + dp[c][i][j]) % MOD;
                }
                dp[c][i][0] = rollSum;
                allSum = (allSum + rollSum) % MOD;
            }
            sum = allSum;
        }
        return (int) sum;
    }
}
