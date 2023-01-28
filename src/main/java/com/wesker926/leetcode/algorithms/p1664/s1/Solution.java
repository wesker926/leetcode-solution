package com.wesker926.leetcode.algorithms.p1664.s1;

/**
 * @author wesker.gh
 * @date 2023/1/28
 * @description DP
 * 前后缀问题，但是不需要维持前后缀和数组
 * 在遍历过程中前后缀可以转移，因此可以认为是DP问题
 */
public class Solution {
    public int waysToMakeFair(int[] nums) {
        int[] dp = new int[4];
        for (int i = 0; i < nums.length; i++) {
            dp[(i & 1) + 2] += nums[i];
        }
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            dp[(i & 1) + 2] -= nums[i];
            if (dp[0] + dp[3] == dp[1] + dp[2]) {
                ans++;
            }
            dp[i & 1] += nums[i];
        }
        return ans;
    }
}
