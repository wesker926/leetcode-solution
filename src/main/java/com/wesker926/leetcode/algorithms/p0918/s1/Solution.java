package com.wesker926.leetcode.algorithms.p0918.s1;

/**
 * @author wesker.gh
 * @date 2023/7/20
 * @description 取反
 * 求最大和最小，然后返回max(max, sum - min)
 * 注意特判：max小于0时不存在正数，此时min将包含所有元素，将返回空子数组，要规避这种情况
 */
public class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int max = nums[0], min = max, pre1 = 0, pre2 = 0, sum = 0;
        for (int num : nums) {
            sum += num;
            max = Math.max(max, (pre1 += num));
            if (pre1 < 0) pre1 = 0;
            min = Math.min(min, (pre2 += num));
            if (pre2 > 0) pre2 = 0;
        }
        return max < 0 ? max : Math.max(max, sum - min);
    }
}
