package com.wesker926.leetcode.algorithms.p0153.s1;

/**
 * @author wesker.gh
 * @date 2022/6/1
 * @description 二分
 */
public class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        // 先排除未旋转的情况
        if (nums[0] <= nums[n - 1]) {
            return nums[0];
        }
        int l = 0, r = n - 1, m;
        while (l <= r) {
            m = l + (r - l) / 2;
            if (nums[m] >= nums[0]) {
                //旋转的左半区
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return nums[l];
    }
}
