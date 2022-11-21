package com.wesker926.leetcode.algorithms.p0808.s1;

/**
 * @author wesker.gh
 * @date 2022/11/21
 * @description DP + 概率论 + 精度特判
 * 牛逼的一题
 * 因为每轮中，A减少的期望大于B减少的期望
 * 所以轮数越多，所求值越大
 * 当n>=4475的时候，该值与1的差距已经在精度允许范围内
 * 所以n>=4475时，可以直接返回1
 */
public class Solution {

    private static final int[][] DIRS = new int[][]{{-4, 0}, {-3, -1}, {-2, -2}, {-1, -3}};

    public double soupServings(int n) {
        if (n >= 4475) {
            return 1;
        }
        n = (int) Math.ceil((double) n / 25);
        double[][] dp = new double[n + 1][n + 1];
        dp[0][0] = 0.5;
        for (int i = 1; i <= n; i++) {
            dp[0][i] = 1.0;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int[] dir : DIRS) {
                    dp[i][j] += dp[Math.max(0, i + dir[0])][Math.max(0, j + dir[1])];
                }
                dp[i][j] /= 4;
            }
        }
        return dp[n][n];
    }
}
