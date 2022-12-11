package com.wesker926.leetcode.algorithms.p1827.s1;

/**
 * @author wesker.gh
 * @date 2022/12/11
 * @description 贪心
 */
public class Solution {
    public int minOperations(int[] nums) {
        int ans = 0, pre = nums[0];
        for (int i = 1; i < nums.length; i++) {
            pre = Math.max(pre + 1, nums[i]);
            ans += pre - nums[i];
        }
        return ans;
    }
}
