package com.wesker926.leetcode.algorithms.p0044.s1;

/**
 * @author wesker.gh
 * @date 2022/4/30
 * @description DP
 */
public class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        char[] scs = s.toCharArray();
        char[] pcs = p.toCharArray();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int j = 1; j <= n; j++) {
            if (pcs[j - 1] == '*') {
                dp[j] = true;
            } else {
                break;
            }
        }

        for (int i = 1; i <= m; i++) {
            boolean pre = dp[0], temp;
            dp[0] = false;
            for (int j = 1; j <= n; j++) {
                temp = dp[j];
                dp[j] = false;
                if (pcs[j - 1] == scs[i - 1] || pcs[j - 1] == '?') {
                    dp[j] = pre;
                } else if (pcs[j - 1] == '*') {
                    dp[j] = dp[j - 1] || temp;
                }
                pre = temp;
            }
        }
        return dp[n];
    }
}
