package com.wesker926.leetcode.lcof.p062.s1;

/**
 * @author wesker.gh
 * @date 2022/4/19
 * @description DP + 递归
 * f(n) = (f(n - 1) + m) % n
 */
public class Solution {
    public int lastRemaining(int n, int m) {
        return n == 1 ? 0 : (lastRemaining(n - 1, m) + m) % n;
    }
}
