package com.wesker926.leetcode.algorithms.p0396.s1;

/**
 * @author wesker.gh
 * @date 2022/4/22
 * @description DP（f(n) = f(n - 1) + sum - len * nums[len - n]）
 */
public class Solution {
    public int maxRotateFunction(int[] nums) {
        int sum = 0, dp = 0, ans = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            dp += i * nums[i];
        }
        ans = dp;
        for (int i = nums.length - 1; i > 0; i--) {
            dp += sum - nums.length * nums[i];
            ans = Math.max(ans, dp);
        }
        return ans;
    }
}
