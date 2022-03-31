package com.wesker926.leetcode.lcof.p015.s1;

/**
 * @author wesker.gh
 * @date 2022/3/31
 * @description 位运算 n & (n - 1)可移除最后一位1
 */
public class Solution {

    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        for (; n != 0; n &= n - 1) {
            count++;
        }
        return count;
    }
}
