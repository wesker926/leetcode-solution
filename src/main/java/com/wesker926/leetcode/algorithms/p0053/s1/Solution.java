package com.wesker926.leetcode.algorithms.p0053.s1;

/**
 * @author wesker.gh
 * @date 2022/5/1
 * @description DP
 */
public class Solution {
    public int maxSubArray(int[] nums) {
        int ans = nums[0];
        for (int i = 0, sum = 0; i < nums.length; i++) {
            sum += nums[i];
            ans = Math.max(ans, sum);
            sum = Math.max(sum, 0);
        }
        return ans;
    }
}
