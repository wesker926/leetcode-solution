package com.wesker926.leetcode.algorithms.p0322.s1;

import java.util.Arrays;

/**
 * @author wesker.gh
 * @date 2022/5/30
 * @description DP
 */
public class Solution {
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            dp[i] = amount + 1;
            for (int j = 0; j < coins.length && coins[j] <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
