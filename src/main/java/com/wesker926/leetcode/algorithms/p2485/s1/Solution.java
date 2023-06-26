package com.wesker926.leetcode.algorithms.p2485.s1;

/**
 * @author wesker.gh
 * @date 2023/6/26
 * @description 二分
 */
public class Solution {
    public int pivotInteger(int n) {
        int l = 1, r = n, m;
        while (l <= r) {
            m = l + (r - l) / 2;
            if ((1 + m) * m < (m + n) * (n - m + 1)) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return (1 + l) * l == (l + n) * (n - l + 1) ? l : -1;
    }
}
