package com.wesker926.leetcode.algorithms.p0075.s1;

/**
 * @author wesker.gh
 * @date 2022/5/5
 * @description 双向三指针
 */
public class Solution {
    public void sortColors(int[] nums) {
        for (int i = 0, j = 0, k = nums.length - 1; j <= k; j++) {
            if (nums[j] == 0) {
                nums[j] = 1;
                nums[i++] = 0;
            } else if (nums[j] == 2) {
                for (; k > j && nums[k] == 2; k--) {
                }
                nums[j] = 1;
                if (nums[k] == 0) {
                    nums[i++] = 0;
                }
                nums[k--] = 2;
            }
        }
    }
}
