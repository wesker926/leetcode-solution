package com.wesker926.leetcode.algorithms.p0033.s1;

/**
 * @author wesker.gh
 * @date 2022/4/28
 * @description 二分（注意元素唯一）
 */
public class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1, m;
        while (l <= r) {
            m = (l + r) / 2;
            if (nums[m] == target) {
                return m;
            } else if (nums[m] > target) {
                if (nums[m] >= nums[0] && target < nums[0]) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            } else {
                if (target >= nums[0] && nums[m] < nums[0]) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            }
        }
        return -1;
    }
}
