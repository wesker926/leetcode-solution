package com.wesker926.leetcode.algorithms.p0313.s1;

/**
 * @author wesker.gh
 * @date 2022/6/14
 * @description DP
 */
public class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] ans = new int[n];
        int[] dp = new int[primes.length];
        ans[0] = 1;
        for (int i = 1; i < n; i++) {
            ans[i] = Integer.MAX_VALUE;
            for (int j = 0; j < dp.length; j++) {
                ans[i] = Math.min(ans[i], ans[dp[j]] * primes[j]);
            }
            for (int j = 0; j < dp.length; j++) {
                if (ans[dp[j]] * primes[j] == ans[i]) {
                    dp[j]++;
                }
            }
        }
        return ans[n - 1];
    }
}
