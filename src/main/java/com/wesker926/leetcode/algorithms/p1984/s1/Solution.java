package com.wesker926.leetcode.algorithms.p1984.s1;

import java.util.Arrays;

/**
 * @author wesker.gh
 * @date 2022/2/11
 * @description 排序 + 滑动窗口
 */
public class Solution {
    public int minimumDifference(int[] nums, int k) {
        if (k == 1) {
            return 0;
        }

        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        for (int i = k - 1; i < nums.length; i++) {
            min = Math.min(nums[i] - nums[i - k + 1], min);
        }
        return min;
    }
}
