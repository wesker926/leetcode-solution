package com.wesker926.leetcode.algorithms.p0080.s1;

/**
 * @author wesker.gh
 * @date 2022/5/6
 * @description 双指针
 */
public class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (i < 2 || nums[i - 2] != nums[j]) {
                nums[i++] = nums[j];
            }
        }
        return i;
    }
}
