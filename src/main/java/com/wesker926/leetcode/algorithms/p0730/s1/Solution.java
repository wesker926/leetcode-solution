package com.wesker926.leetcode.algorithms.p0730.s1;

/**
 * @author wesker.gh
 * @date 2022/6/10
 * @description DP（三维）
 */
public class Solution {

    private static final int MOD = (int) (1e9 + 7);

    public int countPalindromicSubsequences(String s) {
        int n = s.length();
        int[][][] dp = new int[n][n][4];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                for (int k = 0; k < 4; k++) {
                    char ch = (char) (k + 'a');
                    if (i == j) {
                        dp[i][j][k] = ch == s.charAt(i) ? 1 : 0;
                        continue;
                    }

                    if (s.charAt(i) == ch && s.charAt(j) == ch) {
                        dp[i][j][k] = 2;
                        for (int l = 0; l < 4; l++) {
                            dp[i][j][k] = (dp[i][j][k] + dp[i + 1][j - 1][l]) % MOD;
                        }
                    } else if (s.charAt(i) == ch) {
                        dp[i][j][k] = dp[i][j - 1][k];
                    } else if (s.charAt(j) == ch) {
                        dp[i][j][k] = dp[i + 1][j][k];
                    } else {
                        dp[i][j][k] = dp[i + 1][j - 1][k];
                    }
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < 4; i++) {
            ans = (dp[0][n - 1][i] + ans) % MOD;
        }
        return ans;
    }
}
