package com.wesker926.leetcode.algorithms.p0795.s3;

/**
 * @author wesker.gh
 * @date 2022/11/24
 * @description 计数
 * 统计不大于max的子区间的数量
 * ans = count(nums, right) - count(nums, left - 1)
 */
public class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        return count(nums, right) - count(nums, left - 1);
    }

    private int count(int[] nums, int max) {
        int ans = 0, l = -1, r = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                l = i;
            }
            ans += r - l;
        }
        return ans;
    }
}
