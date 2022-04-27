package com.wesker926.leetcode.algorithms.p0029.s1;

/**
 * @author wesker.gh
 * @date 2022/4/27
 * @description 快速除（迭代）
 */
public class Solution {
    public int divide(int dividend, int divisor) {
        if (divisor == Integer.MIN_VALUE) {
            return dividend == Integer.MIN_VALUE ? 1 : 0;
        }

        boolean sign = true;
        int ans = 0, i = 0, add = 0;
        if (dividend == Integer.MIN_VALUE) {
            if (Math.abs(divisor) == 1) {
                return divisor > 0 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            dividend = dividend + Math.abs(divisor);
            add++;
        }
        if ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)) {
            sign = false;
        }
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);

        for (int h = 1 << 30; dividend >= divisor && (divisor & h) == 0; divisor <<= 1) {
            i++;
        }
        for (; i >= 0; i--) {
            ans <<= 1;
            if (dividend >= divisor) {
                dividend -= divisor;
                ans |= 1;
            }
            divisor >>= 1;
        }
        ans += add;
        return sign ? ans : -ans;
    }
}