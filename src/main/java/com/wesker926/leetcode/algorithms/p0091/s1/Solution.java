package com.wesker926.leetcode.algorithms.p0091.s1;

/**
 * @author wesker.gh
 * @date 2022/5/9
 * @description DP
 * 可改造为仅需三个常量
 */
public class Solution {
    public int numDecodings(String s) {
        char[] cs = s.toCharArray();
        int[] dp = new int[cs.length + 1];
        dp[0] = 1;
        for (int i = 0; i < cs.length; i++) {
            dp[i + 1] = cs[i] == '0' ? 0 : dp[i];
            if (i != 0 && (cs[i - 1] == '1' || (cs[i - 1] == '2' && cs[i] < '7'))) {
                dp[i + 1] += dp[i - 1];
            }
        }
        return dp[cs.length];
    }
}
