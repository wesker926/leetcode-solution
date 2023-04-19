package com.wesker926.leetcode.algorithms.p1043.s1;

/**
 * @author wesker.gh
 * @date 2023/4/19
 * @description DP
 * 查表或刷表皆可
 */
public class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int[] dp = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            for (int j = i, c = 1, max = 0; j >= 0 && c <= k; j--, c++) {
                max = Math.max(max, arr[j]);
                dp[i + 1] = Math.max(dp[i + 1], max * c + dp[j]);
            }
        }
        return dp[arr.length];
    }
}
