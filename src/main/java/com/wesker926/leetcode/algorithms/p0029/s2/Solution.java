package com.wesker926.leetcode.algorithms.p0029.s2;

/**
 * @author wesker.gh
 * @date 2022/4/27
 * @description 快速除（递归）
 */
public class Solution {
    public int divide(int dividend, int divisor) {
        if (divisor == Integer.MIN_VALUE) {
            return dividend == Integer.MIN_VALUE ? 1 : 0;
        }

        boolean sign = true;
        int[] ans = new int[]{0, 0};
        if (dividend == Integer.MIN_VALUE) {
            if (Math.abs(divisor) == 1) {
                return divisor > 0 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            dividend = dividend + Math.abs(divisor);
            ans[1]++;
        }
        if ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)) {
            sign = false;
        }

        quickDiv(Math.abs(dividend), Math.abs(divisor), 1, ans);
        ans[0] += ans[1];
        return sign ? ans[0] : -ans[0];
    }

    private int quickDiv(int a, int b, int n, int[] r) {
        if (a - b >= b) {
            a = quickDiv(a, b << 1, n << 1, r);
        }
        if (a >= b) {
            r[0] += n;
            a -= b;
        }
        return a;
    }
}
