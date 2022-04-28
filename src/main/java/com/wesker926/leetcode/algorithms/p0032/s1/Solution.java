package com.wesker926.leetcode.algorithms.p0032.s1;

/**
 * @author wesker.gh
 * @date 2022/4/28
 * @description DP
 */
public class Solution {
    public int longestValidParentheses(String s) {
        int n = s.length(), ans = 0;
        int[] dp = new int[n + 1];
        char[] cs = s.toCharArray();
        for (int i = 0, j; i < n; i++) {
            if (cs[i] == ')' && i > 0) {
                if (cs[i - 1] == '(') {
                    dp[i + 1] = dp[i - 1] + 2;
                } else if ((j = i - dp[i] - 1) >= 0 && cs[j] == '(') {
                    dp[i + 1] = dp[i] + 2 + dp[j];
                }
                ans = Math.max(ans, dp[i + 1]);
            }
        }
        return ans;
    }
}
