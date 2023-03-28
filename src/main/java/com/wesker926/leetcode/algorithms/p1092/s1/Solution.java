package com.wesker926.leetcode.algorithms.p1092.s1;

/**
 * @author wesker.gh
 * @date 2023/3/28
 * @description DP
 * 先DP出最长公共子序列
 * 然后逆序构造字符串
 */
public class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int m = str1.length(), n = str2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                } else {
                    dp[i + 1][j + 1] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = m, j = n; i > 0 || j > 0; ) {
            if (i == 0 || (j != 0 && dp[i][j] == dp[i][j - 1])) {
                sb.append(str2.charAt(--j));
                continue;
            }
            if (j == 0 || dp[i][j] == dp[i - 1][j]) {
                sb.append(str1.charAt(--i));
                continue;
            }
            sb.append(str1.charAt(--i));
            j--;
        }
        return sb.reverse().toString();
    }
}
