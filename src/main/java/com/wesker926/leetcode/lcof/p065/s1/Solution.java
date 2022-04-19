package com.wesker926.leetcode.lcof.p065.s1;

/**
 * @author wesker.gh
 * @date 2022/4/19
 * @description 位运算
 * a + b = c(进位) + d(本位)
 */
public class Solution {
    public int add(int a, int b) {
        return a == 0 ? b : add((a & b) << 1, a ^ b);
    }
}
