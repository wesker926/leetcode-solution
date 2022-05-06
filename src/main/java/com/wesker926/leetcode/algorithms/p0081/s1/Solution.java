package com.wesker926.leetcode.algorithms.p0081.s1;

/**
 * @author wesker.gh
 * @date 2022/5/6
 * @description 二分
 */
public class Solution {
    public boolean search(int[] nums, int target) {
        int l = 0, r = nums.length - 1, m;
        while (l <= r) {
            m = (l + r) / 2;
            if (target == nums[l]) {
                return true;
            }
            if (nums[m] == nums[l]) {
                l++;
                continue;
            }

            if (nums[m] == target) {
                return true;
            } else if (nums[m] > target) {
                if (target < nums[l] && nums[m] > nums[l]) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            } else {
                if (nums[m] < nums[l] && target > nums[l]) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            }
        }
        return false;
    }
}
