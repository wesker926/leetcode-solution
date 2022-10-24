package com.wesker926.leetcode.algorithms.p0915.s1;

/**
 * @author wesker.gh
 * @date 2022/10/24
 * @description 维护右起最小值数组
 */
public class Solution {
    public int partitionDisjoint(int[] nums) {
        int n = nums.length;
        int[] min = new int[n + 1];
        min[n] = Integer.MAX_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            min[i] = Math.min(min[i + 1], nums[i]);
        }
        for (int i = 0, max = 0; i < n - 1; i++) {
            max = Math.max(nums[i], max);
            if (max <= min[i + 1]) {
                return i + 1;
            }
        }
        return -1;
    }
}
