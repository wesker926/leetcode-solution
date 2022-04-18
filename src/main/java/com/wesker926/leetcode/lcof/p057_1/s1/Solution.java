package com.wesker926.leetcode.lcof.p057_1.s1;

/**
 * @author wesker.gh
 * @date 2022/4/18
 * @description 双指针
 */
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int l = 0, r = nums.length - 1, sum;
        while (l <= r) {
            sum = nums[l] + nums[r];
            if (sum == target) {
                return new int[]{nums[l], nums[r]};
            } else if (sum > target) {
                r--;
            } else {
                l++;
            }
        }
        return new int[0];
    }
}
