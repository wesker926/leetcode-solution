package com.wesker926.leetcode.algorithms.p0719.s1;

import java.util.Arrays;

/**
 * @author wesker.gh
 * @date 2022/6/15
 * @description 排序+ 二分 + 双指针
 */
public class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int l = 0, r = nums[n - 1] - nums[0], m, c;
        while (l <= r) {
            m = l + (r - l) / 2;
            c = count(nums, m);
            if (c >= k) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return l;
    }

    private int count(int[] nums, int diff) {
        int ans = 0;
        for (int i = 0, j = 0; i < nums.length; i++) {
            for (; j < nums.length && nums[j] - nums[i] <= diff; j++) {
            }
            ans += Math.max(0, j - i - 1);
        }
        return ans;
    }
}
