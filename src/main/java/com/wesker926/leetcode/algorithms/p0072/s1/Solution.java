package com.wesker926.leetcode.algorithms.p0072.s1;

/**
 * @author wesker.gh
 * @date 2022/5/5
 * @description DP
 */
public class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[] dp = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            dp[i] = i;
        }
        for (int i = 1, pre, temp; i <= m; i++) {
            pre = dp[0];
            dp[0] = i;
            for (int j = 1; j <= n; j++) {
                temp = dp[j];
                dp[j] = Math.min(Math.min(dp[j - 1], temp) + 1, pre + (word1.charAt(i - 1) == word2.charAt(j - 1) ? 0 : 1));
                pre = temp;
            }
        }
        return dp[n];
    }
}
