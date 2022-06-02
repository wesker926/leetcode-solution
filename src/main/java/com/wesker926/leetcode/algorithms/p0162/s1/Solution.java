package com.wesker926.leetcode.algorithms.p0162.s1;

/**
 * @author wesker.gh
 * @date 2022/6/2
 * @description 二分
 * 如果当前m满足，则缩减r范围，否则缩减l范围（此时必然有比l大的符合条件的值）
 */
public class Solution {
    public int findPeakElement(int[] nums) {
        int l = 0, r = nums.length - 1, m;
        while (l < r) {
            m = l + (r - l) / 2;
            if (nums[m] > nums[m + 1]) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }
}
