package com.wesker926.leetcode.algorithms.p0532.s1;

import java.util.Arrays;

/**
 * @author wesker.gh
 * @date 2022/6/16
 * @description 排序 + 遍历 + 二分
 */
public class Solution {
    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int find = nums[i] + k;
            int count = binary(nums, i + 1, find + 1) - binary(nums, i + 1, find);
            ans += count > 0 ? 1 : 0;
        }
        return ans;
    }

    private int binary(int[] nums, int l, int t) {
        int r = nums.length - 1, m;
        while (l <= r) {
            m = l + (r - l) / 2;
            if (nums[m] < t) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return l;
    }
}
