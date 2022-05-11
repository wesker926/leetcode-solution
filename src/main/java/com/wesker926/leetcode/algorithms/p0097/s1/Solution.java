package com.wesker926.leetcode.algorithms.p0097.s1;

/**
 * @author wesker.gh
 * @date 2022/5/11
 * @description DP
 */
public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length(), n = s2.length();
        if (s3.length() != m + n) {
            return false;
        }
        boolean[] dp = new boolean[n + 1];
        for (int i = 0; i <= m; i++) {
            dp[0] = i == 0 || (dp[0] && s1.charAt(i - 1) == s3.charAt(i - 1));
            for (int j = 1; j <= n; j++) {
                dp[j] = (s2.charAt(j - 1) == s3.charAt(i + j - 1) && dp[j - 1])
                        || (i > 0 && s1.charAt(i - 1) == s3.charAt(i + j - 1) && dp[j]);
            }
        }
        return dp[n];
    }
}
