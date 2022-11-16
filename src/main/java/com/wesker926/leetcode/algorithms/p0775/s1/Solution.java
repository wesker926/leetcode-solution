package com.wesker926.leetcode.algorithms.p0775.s1;

/**
 * @author wesker.gh
 * @date 2022/11/16
 * @description 前缀最大值
 * 维护前缀最大值X(i)，确保nums[i + 2] >= X(i)
 * 否则，存在非局部倒置
 */
public class Solution {
    public boolean isIdealPermutation(int[] nums) {
        int max = nums[0];
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] < max) {
                return false;
            }
            max = Math.max(max, nums[i - 1]);
        }
        return true;
    }
}
