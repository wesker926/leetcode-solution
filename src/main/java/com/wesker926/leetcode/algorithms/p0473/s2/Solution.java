package com.wesker926.leetcode.algorithms.p0473.s2;

/**
 * @author wesker.gh
 * @date 2022/6/1
 * @description DP
 * 以状态mask作为DP下标
 */
public class Solution {
    public boolean makesquare(int[] matchsticks) {
        int n = matchsticks.length, sum = 0, total = 1 << n;
        for (int matchstick : matchsticks) {
            sum += matchstick;
        }
        if ((sum & 3) != 0) {
            return false;
        }
        sum >>= 2;
        int[] dp = new int[total];
        for (int i = 1; i < total; i++) {
            dp[i] = -1;
            for (int j = 0, k; j < n; j++) {
                if ((i & (1 << j)) == 0) {
                    continue;
                }
                k = i - (1 << j);
                if (dp[k] < 0) {
                    continue;
                }
                if (matchsticks[j] + dp[k] <= sum) {
                    dp[i] = (matchsticks[j] + dp[k]) % sum;
                    break;
                }
            }
        }
        return dp[total - 1] == 0;
    }
}
