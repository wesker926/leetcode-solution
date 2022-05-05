package com.wesker926.leetcode.algorithms.p0713.s1;

/**
 * @author wesker.gh
 * @date 2022/5/5
 * @description 滑动窗口
 */
public class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int ans = 0;
        for (int i = 0, j = 0, mul = 1; j < nums.length; j++) {
            mul *= nums[j];
            while (i <= j && mul >= k) {
                mul /= nums[i++];
            }
            ans += j - i + 1;
        }
        return ans;
    }
}
