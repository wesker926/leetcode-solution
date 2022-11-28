package com.wesker926.leetcode.algorithms.p0813.s1;

/**
 * @author wesker.gh
 * @date 2022/11/28
 * @description DP
 * 平均值和最大的分组的子数组数目必定是k
 * dp[i][j]，i表示区间[0,i-1]范围，j表示分为j组
 * dp[i][j] = max(dp[x][j - 1] + sum([x,i - 1]) / (i - x)), (j - 1 <= x < i)
 * 即分j组的最大值为max（分j-1组时有效区间范围内的最大值 + 剩余数字平均值和）
 */
public class Solution {
    public double largestSumOfAverages(int[] nums, int k) {
        int n = nums.length;
        double[] pre = new double[n + 1], dp = new double[n + 1];
        for (int i = 0; i < n; i++) {
            pre[i + 1] = pre[i] + nums[i];
            dp[i + 1] = pre[i + 1] / (i + 1);
        }
        for (int j = 2; j <= k; j++) {
            for (int i = n; i >= j; i--) {
                for (int x = j - 1; x < i; x++) {
                    dp[i] = Math.max(dp[i], dp[x] + (pre[i] - pre[x]) / (i - x));
                }
            }
        }
        return dp[n];
    }
}
