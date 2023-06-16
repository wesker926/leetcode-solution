package com.wesker926.leetcode.algorithms.p2481.s1;

/**
 * @author wesker.gh
 * @date 2023/6/17
 * @description 分情况讨论
 */
public class Solution {
    public int numberOfCuts(int n) {
        return n == 1 ? 0 : ((n & 1) == 0 ? n >> 1 : n);
    }
}
