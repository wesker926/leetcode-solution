package com.wesker926.leetcode.algorithms.p1262.s1;

/**
 * @author wesker.gh
 * @date 2023/6/19
 * @description DP
 */
public class Solution {
    public int maxSumDivThree(int[] nums) {
        int[][] dp = new int[2][3];
        for (int num : nums) {
            System.arraycopy(dp[0], 0, dp[1], 0, 3);
            int mod = num % 3;
            dp[1][mod] = Math.max(dp[1][mod], num);
            for (int j = 0; j < 3; j++) {
                if (dp[0][j] == 0) continue;
                mod = (num + dp[0][j]) % 3;
                dp[1][mod] = Math.max(dp[1][mod], num + dp[0][j]);
            }
            System.arraycopy(dp[1], 0, dp[0], 0, 3);
        }
        return dp[0][0];
    }
}
