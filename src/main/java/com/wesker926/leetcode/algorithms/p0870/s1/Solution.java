package com.wesker926.leetcode.algorithms.p0870.s1;

import java.util.Arrays;

/**
 * @author wesker.gh
 * @date 2022/10/8
 * @description 贪心
 * 田忌赛马，用最大的nums1覆盖最大的nums2，如果覆盖不了，就用最小的nums1消耗最大的nums2
 */
public class Solution {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        int n = nums1.length;
        Integer[] idxs = new Integer[n];
        for (int i = 0; i < n; i++) {
            idxs[i] = i;
        }
        Arrays.sort(nums1);
        Arrays.sort(idxs, (i1, i2) -> nums2[i2] - nums2[i1]);
        int[] ans = new int[n];
        for (int left = 0, right = n - 1, i = 0; i < n; i++) {
            int idx = idxs[i];
            ans[idx] = nums1[right] > nums2[idx] ? nums1[right--] : nums1[left++];
        }
        return ans;
    }
}
