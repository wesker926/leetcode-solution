package com.wesker926.leetcode.algorithms.p0053.s2;

/**
 * @author wesker.gh
 * @date 2022/5/1
 * @description DP
 */
public class Solution {
    public int maxSubArray(int[] nums) {
        int ans = nums[0];
        for (int i = 0, pre = 0; i < nums.length; i++) {
            pre = Math.max(nums[i], pre + nums[i]);
            ans = Math.max(ans, pre);
        }
        return ans;
    }
}
