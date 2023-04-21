package com.wesker926.leetcode.algorithms.p2413.s1;

/**
 * @author wesker.gh
 * @date 2023/4/21
 * @description 数学
 * 奇偶性判断，可通过位运算优化
 */
public class Solution {
    public int smallestEvenMultiple(int n) {
//        return (n & 1) == 0 ? n : (n << 1);
        return n << (n & 1);
    }
}
