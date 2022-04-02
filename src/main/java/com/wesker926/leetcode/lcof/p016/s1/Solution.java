package com.wesker926.leetcode.lcof.p016.s1;

/**
 * @author wesker.gh
 * @date 2022/4/2
 * @description 快速幂
 */
public class Solution {
    public double myPow(double x, int n) {
        return n < 0 ? 1 / pow(x, -(long) n) : pow(x, n);
    }

    private double pow(double x, long n) {
        if (n == 0) {
            return 1;
        }
        return pow(x * x, n >> 1) * ((n & 1) == 0 ? 1 : x);
    }
}
