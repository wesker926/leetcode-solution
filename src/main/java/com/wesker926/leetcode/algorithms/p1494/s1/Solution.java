package com.wesker926.leetcode.algorithms.p1494.s1;

import java.util.Arrays;

/**
 * @author wesker.gh
 * @date 2023/6/16
 * @description DP + 位运算
 * https://leetcode.cn/problems/parallel-courses-ii/solutions/2306009/bing-xing-ke-cheng-ii-by-leetcode-soluti-l0mo/
 */
public class Solution {
    public int minNumberOfSemesters(int n, int[][] relations, int k) {
        int t = 1 << n;
        int[] dp = new int[t], need = new int[t];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for (int[] r : relations) need[1 << (r[1] - 1)] |= 1 << (r[0] - 1);
        dp[0] = 0;
        for (int i = 1; i < t; i++) {
            need[i] = need[i & (i - 1)] | need[i & (-i)];
            if ((need[i] | i) != i) continue;
            int valid = i ^ need[i];
            if (Integer.bitCount(valid) <= k) dp[i] = Math.min(dp[i], dp[valid ^ i] + 1);
            else for (int sub = valid; sub > 0; sub = (sub - 1) & valid) {
                if (Integer.bitCount(sub) <= k) dp[i] = Math.min(dp[i], dp[sub ^ i] + 1);
            }
        }
        return dp[t - 1];
    }
}