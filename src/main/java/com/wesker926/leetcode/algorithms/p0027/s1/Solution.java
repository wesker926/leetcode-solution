package com.wesker926.leetcode.algorithms.p0027.s1;

/**
 * @author wesker.gh
 * @date 2022/4/27
 * @description 双指针
 */
public class Solution {
    public int removeElement(int[] nums, int val) {
        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[idx++] = nums[i];
            }
        }
        return idx;
    }
}
