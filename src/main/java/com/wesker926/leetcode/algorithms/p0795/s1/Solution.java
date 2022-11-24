package com.wesker926.leetcode.algorithms.p0795.s1;

import java.util.Arrays;

/**
 * @author wesker.gh
 * @date 2022/11/24
 * @description 单调栈
 * 效果不好
 */
public class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int n = nums.length, idx = 0, ans = 0;
        int[] stack = new int[n];
        int[][] limits = new int[n][2];
        for (int[] limit : limits) {
            limit[0] = -1;
            limit[1] = n;
        }
        for (int i = 0; i < n; i++) {
            for (; idx != 0 && nums[stack[idx - 1]] <= nums[i]; idx--) {
                limits[stack[idx - 1]][1] = i;
            }
            if (idx != 0) {
                limits[i][0] = stack[idx - 1];
            }
            stack[idx++] = i;
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] >= left && nums[i] <= right) {
                ans += (limits[i][1] - i) * (i - limits[i][0]);
            }
        }
        return ans;
    }
}
