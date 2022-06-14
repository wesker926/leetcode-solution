package com.wesker926.leetcode.algorithms.p0275.s2;

/**
 * @author wesker.gh
 * @date 2022/6/14
 * @description 二分
 * 根据右侧满足的count判断
 */
public class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length, l = 0, r = citations.length - 1, m;
        while (l <= r) {
            m = l + (r - l) / 2;
            if (n - m <= citations[m]) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        // n - (r + 1) == n - l
        return n - l;
    }
}
