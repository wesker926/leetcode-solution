package com.wesker926.leetcode.algorithms.p2485.s2;

/**
 * @author wesker.gh
 * @date 2023/6/26
 * @description 数学
 */
public class Solution {
    public int pivotInteger(int n) {
        int t = (n * n + n) / 2, x = (int) Math.sqrt(t);
        return x * x == t ? x : -1;
    }
}