package com.wesker926.leetcode.lcof.p003.s1;

/**
 * @author wesker.gh
 * @date 2022/3/29
 * @description 原位替换
 */
public class Solution {
    public int findRepeatNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int a = nums[i] >= 0 ? nums[i] : -nums[i] - 1;
            if (nums[a] < 0) {
                return a;
            }
            nums[a] = -nums[a] - 1;
        }
        return -1;
    }
}
