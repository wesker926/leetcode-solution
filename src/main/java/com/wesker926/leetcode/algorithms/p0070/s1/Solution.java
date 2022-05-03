package com.wesker926.leetcode.algorithms.p0070.s1;

/**
 * @author wesker.gh
 * @date 2022/5/3
 * @description DP（同lcof-p010_2）
 */
public class Solution {
    public int climbStairs(int n) {
        int a = 0, b = 1;
        for (; n > 0; n--) {
            b += a;
            a = b - a;
        }
        return b;
    }
}
