package com.wesker926.leetcode.lcof.p062.s2;

/**
 * @author wesker.gh
 * @date 2022/4/19
 * @description DP + 迭代（同主站-p1823）
 */
public class Solution {
    public int lastRemaining(int n, int m) {
        int x = 0;
        for (int i = 2; i <= n; i++) {
            x = (x + m) % i;
        }
        return x;
    }
}
