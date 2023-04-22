package com.wesker926.leetcode.algorithms.p1027.s2;

/**
 * @author wesker.gh
 * @date 2023/4/22
 * @description DP
 * dp[i][diff]表示以nums[i]结尾且等差为diff的最长子序列的长度
 * 内层循环倒序可以优化，因为相同diff情况下，靠后的j的信息更多，就不再需要判断相同diff下靠前的j了
 */
public class Solution {
    public int longestArithSeqLength(int[] nums) {
        int ans = 0, n = nums.length;
        int[][] dp = new int[n][1001];
        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                int diff = nums[i] - nums[j] + 500;
                if (dp[i][diff] == 0) {
                    ans = Math.max(ans, dp[i][diff] = dp[j][diff] + 1);
                }
            }
        }
        return ans + 1;
    }
}
