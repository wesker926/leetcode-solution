package com.wesker926.leetcode.algorithms.p0746.s1;

/**
 * @author wesker.gh
 * @date 2023/12/17
 * @description DP
 * 定义dp[i]为从第i个台阶爬上去的cost，则dp[i] = min(dp[i - 1], dp[i - 2]) + cost[i]
 */
public class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int a = 0, b = 0;
        for (int i = 0, t; i < cost.length; i++, a = b, b = t) {
            t = cost[i] + Math.min(a, b);
        }
        return Math.min(a, b);
    }
}
