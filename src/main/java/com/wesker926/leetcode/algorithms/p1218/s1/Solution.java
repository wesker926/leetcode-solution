package com.wesker926.leetcode.algorithms.p1218.s1;

/**
 * @author wesker.gh
 * @date 2021/11/5
 * @description dp
 */
public class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        int[] dp = new int[20001];
        int cur, pre, max = 0;
        for (int i : arr) {
            cur = i + 10000;
            pre = cur - difference;
            dp[cur] = pre >= 0 && pre <= 20000 ? dp[pre] + 1 : 1;
            max = Math.max(max, dp[cur]);
        }
        return max;
    }
}
