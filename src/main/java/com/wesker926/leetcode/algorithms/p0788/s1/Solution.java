package com.wesker926.leetcode.algorithms.p0788.s1;

/**
 * @author wesker.gh
 * @date 2022/9/25
 * @description 数位DP
 * DP维度：数位 + 数位数字边缘0/所有1 + 镜像0/总1
 * 也可直接遍历模拟
 */
public class Solution {

    private static final int[] CHECK = new int[]{0, 0, 1, -1, -1, 1, 1, -1, 0, 1};

    public int rotatedDigits(int n) {
        char[] cs = String.valueOf(n).toCharArray();
        int[] nums = new int[cs.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = cs[i] - '0';
        }
        int len = nums.length;
        int[][][] dp = new int[len + 1][2][2];
        dp[0][0][1] = dp[0][1][1] = 1;
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    int sum = 0, curLimit = nums[len - i];
                    for (int l = 0; l <= (j == 0 ? 9 : curLimit); l++) {
                        if (CHECK[l] < 0) {
                            continue;
                        }
                        sum += dp[i - 1][j == 1 && l == curLimit ? 1 : 0][CHECK[l] == 1 || k == 1 ? 1 : 0];
                    }
                    dp[i][j][k] = sum;
                }
            }
        }
        return dp[len][1][0];
    }
}
