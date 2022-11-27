package com.wesker926.leetcode.algorithms.p1752.s1;

/**
 * @author wesker.gh
 * @date 2022/11/27
 * @description 遍历
 * 数组是非递减的，或者是两段非递减的且后段最大值不大于前段最小值
 */
public class Solution {
    public boolean check(int[] nums) {
        int n = nums.length, idx = 1;
        for (; idx < n && nums[idx] >= nums[idx - 1]; idx++) {
        }
        if (idx == n) {
            return true;
        }
        for (idx++; idx < n && nums[idx] >= nums[idx - 1]; idx++) {
        }
        return idx == n && nums[n - 1] <= nums[0];
    }
}
