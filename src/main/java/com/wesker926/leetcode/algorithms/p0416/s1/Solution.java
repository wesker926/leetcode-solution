package com.wesker926.leetcode.algorithms.p0416.s1;

/**
 * @author wesker.gh
 * @date 2022/5/31
 * @description DP
 * 这是个NP完全问题
 * 可题目转化为01背包问题，最后判断最大价值是否等于和的一半
 * 注：01背包问题可以做一维数组优化，注意其遍历方向
 */
public class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length, sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if ((sum & 1) == 1) {
            return false;
        }
        sum >>= 1;
        int[] dp = new int[sum + 1];
        for (int num : nums) {
            for (int j = sum; j > 0; j--) {
                dp[j] = num > j ? dp[j] : Math.max(dp[j], dp[j - num] + num);
            }
        }
        return dp[sum] == sum;
    }
}
