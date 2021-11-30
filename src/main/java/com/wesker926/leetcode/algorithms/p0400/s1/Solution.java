package com.wesker926.leetcode.algorithms.p0400.s1;

/**
 * @author wesker.gh
 * @date 2021/11/30
 * @description 计算数与位
 */
public class Solution {
    public int findNthDigit(int n) {
        // 注意溢出问题
        long d = 1;
        for (long i = 9; n > i * d; n -= i * d, i *= 10, d++) {
        }
        long cur = (int) Math.pow(10, d - 1) + (n - 1) / d;
        long pos = d - 1 - ((n - 1) % d);
        for (; pos > 0; pos--, cur /= 10) {
        }
        return (int) (cur % 10);
    }
}
