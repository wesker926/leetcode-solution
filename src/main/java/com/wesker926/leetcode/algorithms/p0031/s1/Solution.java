package com.wesker926.leetcode.algorithms.p0031.s1;

/**
 * @author wesker.gh
 * @date 2022/4/27
 * @description 扫描
 * 关联 主站-p0556
 */
public class Solution {
    public void nextPermutation(int[] nums) {
        int idx = nums.length - 2;
        for (; idx >= 0; idx--) {
            if (nums[idx] < nums[idx + 1]) {
                break;
            }
        }
        if (idx >= 0) {
            swap(nums, binary(nums, idx + 1, nums.length - 1, nums[idx]), idx);
        }
        for (int l = idx + 1, r = nums.length - 1; l < r; l++, r--) {
            swap(nums, l, r);
        }
    }

    private int binary(int[] nums, int l, int r, int t) {
        int m;
        while (l <= r) {
            m = (l + r) / 2;
            if (nums[m] > t) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return r;
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
