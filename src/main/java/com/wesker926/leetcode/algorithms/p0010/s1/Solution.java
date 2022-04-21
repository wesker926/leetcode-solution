package com.wesker926.leetcode.algorithms.p0010.s1;

/**
 * @author wesker.gh
 * @date 2022/4/21
 * @description DP（同lcof-p019）
 */
public class Solution {
    public boolean isMatch(String s, String p) {
        char[] chs = s.toCharArray();
        char[] chp = p.toCharArray();
        boolean[][] dp = new boolean[chs.length + 1][chp.length + 1];
        dp[0][0] = true;
        for (int i = 0; i <= chs.length; i++) {
            for (int j = 0; j <= chp.length; j++) {
                if (j == 0) {
                    continue;
                }
                if (chp[j - 1] != '*') {
                    if (i != 0 && (chs[i - 1] == chp[j - 1] || chp[j - 1] == '.')) {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                    continue;
                }
                if (j == 1) {
                    continue;
                }
                dp[i][j] = dp[i][j - 2];
                if (i != 0 && (chs[i - 1] == chp[j - 2] || chp[j - 2] == '.')) {
                    dp[i][j] |= dp[i - 1][j];
                }
            }
        }
        return dp[chs.length][chp.length];
    }
}
