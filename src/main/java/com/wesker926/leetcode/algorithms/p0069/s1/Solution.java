package com.wesker926.leetcode.algorithms.p0069.s1;

/**
 * @author wesker.gh
 * @date 2022/5/3
 * @description 二分（注意返回r）
 */
public class Solution {
    public int mySqrt(int x) {
        if (x < 4) {
            return x == 0 ? 0 : 1;
        }
        int l = 2, r = x / 2, m, d;
        while (l <= r) {
            m = (r - l) / 2 + l;
            d = x / m;
            if (d == m) {
                return m;
            } else if (d > m) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return r;
    }
}
