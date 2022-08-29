package com.wesker926.leetcode.algorithms.p1470.s1;

/**
 * @author wesker.gh
 * @date 2022/8/29
 * @description 原地 + 位运算
 * num取值范围小于1024，取巧写法
 */
public class Solution {
    public int[] shuffle(int[] nums, int n) {
        for (int i = 0; i < n; i++) {
            nums[i * 2] |= (nums[i] & 1023) << 10;
            nums[i * 2 + 1] |= (nums[i + n] & 1023) << 10;
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] >>= 10;
        }
        return nums;
    }
}
