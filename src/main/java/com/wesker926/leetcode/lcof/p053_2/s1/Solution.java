package com.wesker926.leetcode.lcof.p053_2.s1;

/**
 * @author wesker.gh
 * @date 2022/4/16
 * @description 二分
 */
public class Solution {
    public int missingNumber(int[] nums) {
        int l = 0, r = nums.length - 1, m;
        while (l <= r) {
            m = (l + r) / 2;
            if (nums[m] == m) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return l;
    }
}
