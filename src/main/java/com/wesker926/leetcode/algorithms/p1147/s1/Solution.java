package com.wesker926.leetcode.algorithms.p1147.s1;

/**
 * @author wesker.gh
 * @date 2023/4/12
 * @description 最长公共前后缀（DP）
 * 尝试用KMP的思想去做，但是这题其实可以贪心，所以不是最优
 */
public class Solution {
    public int longestDecomposition(String text) {
        int n = text.length();
        char[] cs = text.toCharArray();
        int[] common = new int[n], dp = new int[n + 1];
        for (int i = (n - 1) >> 1, j = n >> 1, k; i >= 0; i--, j++) {
            longest(cs, common, i, j);
            for (dp[i] = 1, k = common[j]; k > i; k = common[k - 1]) {
                if ((k - i) * 2 <= j - i + 1) {
                    dp[i] = Math.max(dp[i], dp[k] + 2);
                }
            }
        }
        return dp[0];
    }

    private void longest(char[] cs, int[] dp, int st, int ed) {
        dp[st] = st;
        for (int i = st + 1, j = st; i <= ed; i++) {
            for (; j > st && cs[i] != cs[j]; j = dp[j - 1]) ;
            if (cs[i] == cs[j]) {
                j++;
            }
            dp[i] = j;
        }
    }
}
