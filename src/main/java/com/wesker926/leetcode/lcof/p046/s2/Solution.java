package com.wesker926.leetcode.lcof.p046.s2;

/**
 * @author wesker.gh
 * @date 2022/4/15
 * @description DP
 */
public class Solution {
    public int translateNum(int num) {
        char[] cs = String.valueOf(num).toCharArray();
        int[] dp = new int[cs.length + 1];
        dp[0] = 1;
        for (int i = 1; i <= cs.length; i++) {
            dp[i] = dp[i - 1];
            if (i > 1 && (cs[i - 2] == '1' || (cs[i - 2] == '2' && cs[i - 1] < '6'))) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[cs.length];
    }
}
