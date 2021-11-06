package com.wesker926.leetcode.algorithms.p0268.s1;

/**
 * @author wesker.gh
 * @date 2021/11/6
 * @description 原地标记
 */
public class Solution {
    public int missingNumber(int[] nums) {
        int t;
        for (int i = 0; i < nums.length; i++) {
            t = nums[i];
            if (t < 0) {
                t = -t - 1;
            }
            if (t == nums.length) {
                continue;
            }
            nums[t] = -nums[t] - 1;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) {
                return i;
            }
        }
        return nums.length;
    }
}
