package com.wesker926.leetcode.algorithms.p0799.s2;

/**
 * @author wesker.gh
 * @date 2022/11/20
 * @description DP
 * 根据两肩杯子，计算当前杯子。
 */
public class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[] dp = new double[query_row + 1];
        dp[0] = poured;
        for (int i = 1; i <= query_row; i++) {
            for (int j = i; j > 0; j--) {
                dp[j - 1] = Math.max(dp[j - 1] - 1, 0) / 2;
                dp[j] += dp[j - 1];
            }
        }
        return Math.min(dp[query_glass], 1);
    }
}
