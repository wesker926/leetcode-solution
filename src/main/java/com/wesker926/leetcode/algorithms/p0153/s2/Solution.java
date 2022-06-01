package com.wesker926.leetcode.algorithms.p0153.s2;

/**
 * @author wesker.gh
 * @date 2022/6/1
 * @description 二分
 */
public class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int l = 0, r = n - 1, m;
        while (l < r) {
            m = l + (r - l) / 2;
            // nums[m] > nums[r] 等价于条件 nums[l] > nums[r] && nums[m] >= nums[l]
            // 即发生了旋转且m落在左半区
            if (nums[m] > nums[r]) {
                l = m + 1;
            } else {
                // 未发生旋转，或者m落在右半区
                r = m;
            }
        }
        return nums[r];
    }
}
