package com.wesker926.leetcode.algorithms.p0456.s1;

/**
 * @author wesker.gh
 * @date 2022/6/28
 * @description 倒序单调递减栈
 */
public class Solution {
    public boolean find132pattern(int[] nums) {
        int n = nums.length, idx = 0, maxMid = Integer.MIN_VALUE;
        int[] stack = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] < maxMid) {
                return true;
            }
            while (idx != 0 && stack[idx - 1] < nums[i]) {
                maxMid = stack[--idx];
            }
            if (nums[i] > maxMid) {
                stack[idx++] = nums[i];
            }
        }
        return false;
    }
}
