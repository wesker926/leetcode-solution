package com.wesker926.leetcode.algorithms.p0458.s1;

/**
 * @author wesker.gh
 * @date 2021/11/25
 * @description 维度（进制）计算
 */
public class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int n = minutesToTest / minutesToDie + 1;
        double y = Math.log(buckets) / Math.log(n);
        int intY = (int) y;
        return y == intY ? intY : intY + 1;
    }
}
