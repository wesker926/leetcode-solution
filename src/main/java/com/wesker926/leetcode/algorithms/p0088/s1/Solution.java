package com.wesker926.leetcode.algorithms.p0088.s1;

/**
 * @author wesker.gh
 * @date 2022/5/7
 * @description 逆向双指针
 */
public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int idx = m + n - 1, i = m - 1, j = n - 1; idx >= 0; idx--) {
            nums1[idx] = j < 0 || (i >= 0 && nums1[i] >= nums2[j]) ? nums1[i--] : nums2[j--];
        }
    }
}
