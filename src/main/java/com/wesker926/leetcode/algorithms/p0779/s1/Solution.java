package com.wesker926.leetcode.algorithms.p0779.s1;

/**
 * @author wesker.gh
 * @date 2022/10/20
 * @description 递归
 * 可以看到，如果k在当前行的后半段，根据k的位置，它可以映射到当前行的前半段（即上一行）
 */
public class Solution {
    public int kthGrammar(int n, int k) {
        return recursion((int) Math.pow(2, n - 1), k);
    }

    private int recursion(int c, int k) {
        int d2 = c >> 1, d4 = c >> 2;
        return c == 1 ? 0 : (
                k <= d2 ? recursion(d2, k) : (
                        c == 2 ? 1 : recursion(d2, k > d4 * 3 ? k - d4 * 3 : k - d4)
                )
        );
    }
}
