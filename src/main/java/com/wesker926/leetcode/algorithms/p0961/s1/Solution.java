package com.wesker926.leetcode.algorithms.p0961.s1;

/**
 * @author wesker.gh
 * @date 2022/5/21
 * @description 数学
 * 注：长度为4的时候，可能会间隔2，比如(9,2,4,9)。
 */
public class Solution {
    public int repeatedNTimes(int[] nums) {
        for (int i = 3; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] || nums[i] == nums[i - 2] || nums[i] == nums[i - 3]) {
                return nums[i];
            } else if (nums[i - 1] == nums[i - 2] || nums[i - 1] == nums[i - 3]) {
                return nums[i - 1];
            } else if (nums[i - 2] == nums[i - 3]) {
                return nums[i - 2];
            }
        }
        return 0;
    }
}
