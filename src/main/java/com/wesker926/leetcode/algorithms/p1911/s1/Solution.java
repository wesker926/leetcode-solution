package com.wesker926.leetcode.algorithms.p1911.s1;

/**
 * @author wesker.gh
 * @date 2023/7/11
 * @description DP
 */
public class Solution {
    public long maxAlternatingSum(int[] nums) {
        long odd = nums[0], even = 0;
        for (int i = 1; i < nums.length; i++) {
            long temp = Math.max(odd, even + nums[i]);
            even = Math.max(even, odd - nums[i]);
            odd = temp;
        }
        return Math.max(odd, even);
    }
}
