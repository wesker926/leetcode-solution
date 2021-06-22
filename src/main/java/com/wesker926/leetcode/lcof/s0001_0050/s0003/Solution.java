package com.wesker926.leetcode.lcof.s0001_0050.s0003;

/**
 * @author wesker.gh
 * @date 2021/6/22
 * @description 剑指 Offer 03. 数组中重复的数字
 */
public class Solution {
    public int findRepeatNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int a = nums[i] >= 0 ? nums[i] : -nums[i] - 1;
            if (nums[a] < 0) {
                return a;
            }
            nums[a] = -(nums[a] + 1);
        }
        return -1;
    }
}
