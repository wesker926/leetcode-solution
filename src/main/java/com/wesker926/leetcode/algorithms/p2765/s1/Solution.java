package com.wesker926.leetcode.algorithms.p2765.s1;

/**
 * @author wesker.gh
 * @date 2024/1/23
 * @description 双指针
 */
public class Solution {
    public int alternatingSubarray(int[] nums) {
        int res = 0, n = nums.length;
        for (int i = 0, j, k; i < n - 1; i = k == 1 ? j + 1 : j) {
            for (j = i, k = 1; j < n - 1 && nums[j + 1] - nums[j] == k; j++, k *= -1) ;
            res = Math.max(res, j - i + 1);
        }
        return res < 2 ? -1 : res;
    }
}
