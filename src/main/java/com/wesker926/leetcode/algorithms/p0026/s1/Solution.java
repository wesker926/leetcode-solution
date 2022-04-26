package com.wesker926.leetcode.algorithms.p0026.s1;

/**
 * @author wesker.gh
 * @date 2022/4/26
 * @description 双指针
 */
public class Solution {
    public int removeDuplicates(int[] nums) {
        int k = nums.length == 0 ? 0 : 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[k++] = nums[i];
            }
        }
        return k;
    }
}
