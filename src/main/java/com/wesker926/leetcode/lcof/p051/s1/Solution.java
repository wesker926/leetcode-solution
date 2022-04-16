package com.wesker926.leetcode.lcof.p051.s1;

/**
 * @author wesker.gh
 * @date 2022/4/16
 * @description 归并排序
 */
public class Solution {
    public int reversePairs(int[] nums) {
        return mergeSort(nums, new int[nums.length], 0, nums.length - 1);
    }

    private int mergeSort(int[] nums, int[] copy, int s, int e) {
        if (s >= e) {
            return 0;
        }
        int m = (s + e) / 2, ans = 0;
        ans += mergeSort(nums, copy, s, m);
        ans += mergeSort(nums, copy, m + 1, e);
        for (int i = s, j = m + 1, idx = s; i <= m || j <= e; ) {
            if (i <= m && (j > e || nums[i] <= nums[j])) {
                copy[idx++] = nums[i++];
            } else {
                ans += m - i + 1;
                copy[idx++] = nums[j++];
            }
        }
        System.arraycopy(copy, s, nums, s, e - s + 1);
        return ans;
    }
}
