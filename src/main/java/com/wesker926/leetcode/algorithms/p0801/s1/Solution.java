package com.wesker926.leetcode.algorithms.p0801.s1;

/**
 * @author wesker.gh
 * @date 2022/10/10
 * @description DP
 * dp[i][0]表示i位不交换的最小交换次数，dp[i][1]表示i位交换的最小交换次数
 * 分三种情况：1.原始i不需要交换；2.原始i需要交换；3.原始i交不交换皆可
 */
public class Solution {
    public int minSwap(int[] nums1, int[] nums2) {
        int n = nums1.length, a = 0, b = 1;
        for (int i = 1; i < n; i++) {
            int oa = a, ob = b;
            a = b = n;
            if (nums1[i] > nums1[i - 1] && nums2[i] > nums2[i - 1]) {
                a = Math.min(a, oa);
                b = Math.min(b, ob + 1);
            }
            if (nums1[i] > nums2[i - 1] && nums2[i] > nums1[i - 1]) {
                a = Math.min(a, ob);
                b = Math.min(b, oa + 1);
            }
        }
        return Math.min(a, b);
    }
}
