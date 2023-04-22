package com.wesker926.leetcode.algorithms.p1027.s1;

/**
 * @author wesker.gh
 * @date 2023/4/22
 * @description DP
 * 对每种diff做遍历，省空间
 * 但实际diff的种类远小于1000，n最大也才为1000，所以相较于O(n ^ 2)更耗时间
 */
public class Solution {
    public int longestArithSeqLength(int[] nums) {
        int ans = 1;
        int[] dp;
        for (int d = -500; d <= 500; d++) {
            dp = new int[1501];
            for (int num : nums) {
                dp[num + 500] = dp[num - d + 500] + 1;
                ans = Math.max(ans, dp[num + 500]);
            }
        }
        return ans;
    }
}
