package com.wesker926.leetcode.algorithms.p0367.s1;

/**
 * @author wesker.gh
 * @date 2021/11/4
 * @description 二分
 */
public class Solution {
    public boolean isPerfectSquare(int num) {
        if (num == 1) {
            return true;
        }

        if (num < 4) {
            return false;
        }

        int l = 2, r = num / 2, m = 0;
        // 注意溢出问题
        long s;
        while (l <= r) {
            m = l + (r - l) / 2;
            s = (long) m * m;
            if (s == num) {
                return true;
            }

            if (num > s) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        return false;
    }
}
