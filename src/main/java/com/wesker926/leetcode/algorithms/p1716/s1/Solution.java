package com.wesker926.leetcode.algorithms.p1716.s1;

/**
 * @author wesker.gh
 * @date 2022/1/15
 * @description 等差数列求和
 */
public class Solution {
    public int totalMoney(int n) {
        int w = (n - 1) / 7, d = ((n - 1) % 7) + 1;
        return w * 28 + 7 * w * (w - 1) / 2 + (1 + d) * d / 2 + d * w;
    }
}