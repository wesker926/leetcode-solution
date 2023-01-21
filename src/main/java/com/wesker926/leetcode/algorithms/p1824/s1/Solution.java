package com.wesker926.leetcode.algorithms.p1824.s1;

/**
 * @author wesker.gh
 * @date 2023/1/21
 * @description DP
 */
public class Solution {
    public int minSideJumps(int[] obstacles) {
        int n = obstacles.length;
        int[] dp = new int[]{1, 0, 1};
        for (int obstacle : obstacles) {
            if (obstacle != 0) {
                dp[obstacle - 1] = n;
            }
            int min = min(dp) + 1;
            for (int i = 0; i < dp.length; i++) {
                if (i != obstacle - 1 && dp[i] > min) {
                    dp[i] = min;
                }
            }
        }
        return min(dp);
    }

    private int min(int[] dp) {
        return Math.min(dp[0], Math.min(dp[1], dp[2]));
    }
}
