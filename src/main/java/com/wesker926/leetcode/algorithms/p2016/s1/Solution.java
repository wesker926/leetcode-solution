package com.wesker926.leetcode.algorithms.p2016.s1;

/**
 * @author wesker.gh
 * @date 2022/2/26
 * @description 遍历
 */
public class Solution {
    public int maximumDifference(int[] nums) {
        int ans = -1, max = nums[0], min = nums[0];
        for (int num : nums) {
            if (num > max) {
                ans = Math.max(ans, num - min);
                max = num;
            } else if (num < min) {
                min = num;
                max = num;
            }
        }
        return ans;
    }
}
