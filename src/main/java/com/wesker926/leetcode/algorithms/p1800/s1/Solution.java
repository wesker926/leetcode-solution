package com.wesker926.leetcode.algorithms.p1800.s1;

/**
 * @author wesker.gh
 * @date 2022/10/7
 * @description 遍历
 */
public class Solution {
    public int maxAscendingSum(int[] nums) {
        int max = 0, cur = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                cur += nums[i];
            } else {
                max = Math.max(max, cur);
                cur = nums[i];
            }
        }
        return Math.max(max, cur);
    }
}
