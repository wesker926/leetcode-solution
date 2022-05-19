package com.wesker926.leetcode.algorithms.p0462.s1;

import java.util.Arrays;

/**
 * @author wesker.gh
 * @date 2022/5/19
 * @description 找中位数（排序）
 */
public class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int mid = nums[nums.length / 2], ans = 0;
        for (int num : nums) {
            ans += Math.abs(num - mid);
        }
        return ans;
    }
}
