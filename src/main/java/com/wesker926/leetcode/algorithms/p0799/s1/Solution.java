package com.wesker926.leetcode.algorithms.p0799.s1;

/**
 * @author wesker.gh
 * @date 2022/11/20
 * @description DP
 * 根据当前杯子，计算其对两脚杯子的贡献。
 */
public class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[] dp = new double[query_row + 1];
        dp[0] = poured;
        for (int i = 0; i < query_row; i++) {
            for (int j = i; j >= 0; j--) {
                dp[j] = Math.max(dp[j] - 1, 0) / 2;
                dp[j + 1] += dp[j];
            }
        }
        return Math.min(dp[query_glass], 1);
    }
}
