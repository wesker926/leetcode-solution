package com.wesker926.leetcode.algorithms.p0055.s1;

/**
 * @author wesker.gh
 * @date 2022/5/1
 * @description 贪心
 */
public class Solution {
    public boolean canJump(int[] nums) {
        int i = 0;
        for (int j = 0; i <= j && i < nums.length; i++) {
            j = Math.max(j, nums[i] + i);
        }
        return i == nums.length;
    }
}
