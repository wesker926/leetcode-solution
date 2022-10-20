package com.wesker926.leetcode.algorithms.p0779.s2;

/**
 * @author wesker.gh
 * @date 2022/10/20
 * @description 递归
 * 可以看到，当前行奇数位和上一行顺序位是一样的，当前行偶数位是上一行顺序位的取反
 */
public class Solution {
    public int kthGrammar(int n, int k) {
        return n == 1 ? 0 : 1 ^ (k & 1) ^ kthGrammar(n - 1, (k + 1) / 2);
    }
}
