package com.wesker926.leetcode.algorithms.p0647.s1;

import java.util.Arrays;

/**
 * @author wesker.gh
 * @date 2021/12/24
 * @description dp
 */
public class Solution {
    public int countSubstrings(String s) {
        int n = s.length(), ans = 0;
        char[] cs = s.toCharArray();
        boolean[][] dp = new boolean[n][n];
        for (int i = n - 1; i >= 0; i--) {
            ans++;
            Arrays.fill(dp[i], Math.max(0, i - 1), i + 1, true);
            for (int j = i + 1; j < n; j++) {
                dp[i][j] = cs[i] == cs[j] && dp[i + 1][j - 1];
                if (dp[i][j]) {
                    ans++;
                }
            }
        }
        return ans;
    }
}
