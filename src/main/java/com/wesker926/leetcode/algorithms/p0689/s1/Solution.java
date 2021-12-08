package com.wesker926.leetcode.algorithms.p0689.s1;

/**
 * @author wesker.gh
 * @date 2021/12/8
 * @description 滑动窗口
 */
public class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int k2 = k * 2, k3 = k * 3;
        int[] sum = new int[3], max = new int[3], idx = new int[3], ans = null;

        for (int i = 0; i < k - 1; i++) {
            sum[0] += nums[i];
            sum[1] += nums[i + k];
            sum[2] += nums[i + k2];
        }

        for (int i = k3 - 1; i < nums.length; i++) {
            sum[0] += nums[i - k2];
            sum[1] += nums[i - k];
            sum[2] += nums[i];

            if (sum[0] > max[0]) {
                max[0] = sum[0];
                idx[0] = i - k3 + 1;
            }

            if (sum[1] + max[0] > max[1]) {
                max[1] = sum[1] + max[0];
                idx[1] = idx[0];
                idx[2] = i - k2 + 1;
            }

            if (sum[2] + max[1] > max[2]) {
                max[2] = sum[2] + max[1];
                ans = new int[]{idx[1], idx[2], i - k + 1};
            }

            sum[0] -= nums[i - k3 + 1];
            sum[1] -= nums[i - k2 + 1];
            sum[2] -= nums[i - k + 1];
        }

        return ans;
    }
}
