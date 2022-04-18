package com.wesker926.leetcode.lcof.p060.s1;

/**
 * @author wesker.gh
 * @date 2022/4/18
 * @description DP
 */
public class Solution {
    public double[] dicesProbability(int n) {
        long[] dp = new long[6 * n + 1];
        dp[0] = 1;
        for (int c = 1; c <= n; c++) {
            for (int i = c * 6, t = 0; i >= c; i--, t = 0) {
                for (int k = 1; k <= 6 && i - k >= c - 1; k++) {
                    t += dp[i - k];
                }
                dp[i] = t;
            }
        }
        double div = Math.pow(6, n);
        double[] ans = new double[5 * n + 1];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = dp[i + n] / div;
        }
        return ans;
    }
}
