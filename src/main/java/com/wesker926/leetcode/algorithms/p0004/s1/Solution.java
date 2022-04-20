package com.wesker926.leetcode.algorithms.p0004.s1;

/**
 * @author wesker.gh
 * @date 2022/4/20
 * @description 划分数组（难理解的题）
 */
public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length;
        if (len1 > len2) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int l = 0, r = len1, m, n;
        int n1l, n1r, n2l, n2r;
        int maxL = 0, minR = 0;
        while (l <= r) {
            m = (l + r) / 2;
            n = (len1 + len2 + 1) / 2 - m;
            n1l = m == 0 ? Integer.MIN_VALUE : nums1[m - 1];
            n1r = m == len1 ? Integer.MAX_VALUE : nums1[m];
            n2l = n == 0 ? Integer.MIN_VALUE : nums2[n - 1];
            n2r = n == len2 ? Integer.MAX_VALUE : nums2[n];
            if (n1l < n2r) {
                maxL = Math.max(n1l, n2l);
                minR = Math.min(n1r, n2r);
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return ((len1 + len2) & 1) == 1 ? maxL : (maxL + minR) / 2.0;
    }
}
