package com.wesker926.leetcode.algorithms.p0115.s1;

/**
 * @author wesker.gh
 * @date 2022/5/16
 * @description DP
 * dp[i][j]表示以i开始的s和以j开始的t的子序列匹配数量
 * 如果s[i] == t[j]，则dp[i][j] = dp[i+1][j+1] + dp[i+1][j]
 * 否则，dp[i][j] = dp[i+1][j]
 */
public class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length(), n = t.length();
        int[] dp = new int[n + 1];
        dp[n] = 1;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                if (s.charAt(i) == t.charAt(j)) {
                    dp[j] += dp[j + 1];
                }
            }
        }
        return dp[0];
    }
}
