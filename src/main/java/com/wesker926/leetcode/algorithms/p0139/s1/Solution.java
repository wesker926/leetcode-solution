package com.wesker926.leetcode.algorithms.p0139.s1;

import java.util.List;

/**
 * @author wesker.gh
 * @date 2022/5/23
 * @description DP（自底向上）
 */
public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[n] = true;
        for (int i = n - 1; i >= 0; i--) {
            String sub = s.substring(i, n);
            for (String word : wordDict) {
                dp[i] = sub.startsWith(word) && dp[i + word.length()];
                if (dp[i]) {
                    break;
                }
            }
        }
        return dp[0];
    }
}
