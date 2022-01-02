package com.wesker926.leetcode.algorithms.p0390.s1;

/**
 * @author wesker.gh
 * @date 2022/1/2
 * @description 递归模拟
 */
public class Solution {
    public int lastRemaining(int n) {
        return recursion(n, true);
    }

    private int recursion(int n, boolean isLeft) {
        if (n == 1) {
            return 1;
        }

        int nxt = (isLeft ? recursion(n >> 1, false) : recursion(n >> 1, true)) * 2;
        if (!isLeft && (n & 1) == 0) {
            nxt--;
        }
        return nxt;
    }
}
