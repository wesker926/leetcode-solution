package com.wesker926.leetcode.lcof.s0001_0050.s0015;

/**
 * @author wesker.gh
 * @date 2021/6/23
 * @description 剑指 Offer 15. 二进制中1的个数
 */
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int c = 0;
        while (n != 0) {
            c += n & 1;
            n >>>= 1;
        }
        return c;
    }
}
