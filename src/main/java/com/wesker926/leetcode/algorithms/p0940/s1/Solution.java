package com.wesker926.leetcode.algorithms.p0940.s1;

/**
 * @author wesker.gh
 * @date 2022/10/14
 * @description DP
 * 以当前字符结尾的字符串数量需要减去上一轮当前字符结尾的数量防止重复
 */
public class Solution {

    private static final int MOD = (int) 1e9 + 7;

    public int distinctSubseqII(String s) {
        long[] dp = new long[27];
        for (char c : s.toCharArray()) {
            int ch = c - 'a';
            long count = dp[26] + 1 - dp[ch] + MOD;
            dp[ch] = (dp[ch] + count) % MOD;
            dp[26] = (dp[26] + count) % MOD;
        }
        return (int) dp[26];
    }
}
