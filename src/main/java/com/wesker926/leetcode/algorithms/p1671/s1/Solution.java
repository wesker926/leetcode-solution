package com.wesker926.leetcode.algorithms.p1671.s1;

import java.util.Arrays;

/**
 * @author wesker.gh
 * @date 2023/12/22
 * @description 二分
 * 问题可转化为LIS（最长递增子序列），请看P0300
 * https://leetcode.cn/problems/minimum-number-of-removals-to-make-mountain-array/solutions/2570598/zui-chang-di-zeng-zi-xu-lie-by-leetcode-2ipno/?envType=daily-question&envId=2023-12-22
 */
public class Solution {
    public int minimumMountainRemovals(int[] nums) {
        int n = nums.length, res = 0;
        int[] sk = new int[n];
        int[][] seq = new int[n][2];
        for (int k = 0; k < 2; k++) {
            for (int c = 0, i = k * (n - 1), len = 0; c < n; c++, i += 1 - k * 2) {
                int idx = Arrays.binarySearch(sk, 0, len, nums[i]);
                if (idx < 0) idx = -idx - 1;
                if (idx == len) len++;
                seq[i][k] = idx;
                sk[idx] = nums[i];
            }
        }
        for (int i = 0; i < n; i++) {
            if (seq[i][0] > 0 && seq[i][1] > 0) res = Math.max(res, seq[i][0] + seq[i][1] + 1);
        }
        return n - res;
    }
}
