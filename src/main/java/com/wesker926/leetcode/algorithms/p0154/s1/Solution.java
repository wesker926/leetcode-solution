package com.wesker926.leetcode.algorithms.p0154.s1;

/**
 * @author wesker.gh
 * @date 2022/6/1
 * @description 二分
 * 同lcof-p011
 */
public class Solution {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1, m;
        while (l < r) {
            m = l + (r - l) / 2;
            if (nums[m] > nums[r]) {
                l = m + 1;
            } else if (nums[m] < nums[r]) {
                r = m;
            } else {
                // 如果nums[m]等于nums[r]，那么我们可以放心的把r丢掉（l < r所以m != r）
                r--;
            }
        }
        return nums[l];
    }
}
