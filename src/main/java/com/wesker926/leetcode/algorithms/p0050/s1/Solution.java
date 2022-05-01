package com.wesker926.leetcode.algorithms.p0050.s1;

/**
 * @author wesker.gh
 * @date 2022/5/1
 * @description 快速乘
 */
public class Solution {
    public double myPow(double x, int n) {
        return n >= 0 ? quickMul(x, n) : 1 / quickMul(x, -(long) n);
    }

    private double quickMul(double x, long n) {
        return n == 0 ? 1 : (quickMul(x * x, n >> 1) * ((n & 1) == 1 ? x : 1));
    }
}
