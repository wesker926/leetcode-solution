package com.wesker926.leetcode.algorithms.p2367.s1;

/**
 * @author wesker.gh
 * @date 2023/3/31
 * @description 三指针
 */
public class Solution {
    public int arithmeticTriplets(int[] nums, int diff) {
        int n = nums.length, ans = 0;
        for (int i = 0, j = 0, k = 0; k < n; i++) {
            for (; j < n && nums[j] - nums[i] < diff; j++) ;
            k = Math.max(k, j);
            if (j >= n || nums[j] - nums[i] != diff) {
                continue;
            }
            for (; k < n && nums[k] - nums[j] < diff; k++) ;
            ans += k < n && nums[k] - nums[j] == diff ? 1 : 0;
        }
        return ans;
    }
}
