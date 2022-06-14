package com.wesker926.leetcode.algorithms.p0275.s1;

/**
 * @author wesker.gh
 * @date 2022/6/14
 * @description 二分
 * 根据分数判断
 */
public class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length, l = 0, r = citations.length - 1, m;
        while (l <= r) {
            m = l + (r - l) / 2;
            if (citations[m] <= n - m) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return Math.max(l == 0 ? 0 : citations[l - 1], l == n ? 0 : n - l);
    }
}
