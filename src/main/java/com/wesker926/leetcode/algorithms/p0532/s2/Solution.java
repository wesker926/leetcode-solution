package com.wesker926.leetcode.algorithms.p0532.s2;

import java.util.Arrays;

/**
 * @author wesker.gh
 * @date 2022/6/16
 * @description 排序 + 双指针
 */
public class Solution {
    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        int ans = 0, n = nums.length;
        for (int i = 0, j = 0; i < n; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (; j < n && (j <= i || nums[j] - nums[i] < k); j++) {
            }
            if (j < n && nums[j] - nums[i] == k) {
                ans++;
            }
        }
        return ans;
    }
}
