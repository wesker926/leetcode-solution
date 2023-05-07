package com.wesker926.leetcode.algorithms.p1010.s1;

/**
 * @author wesker.gh
 * @date 2023/5/7
 * @description 数学
 * 两数之和进阶版，二元逆推性质，互为唯一逆元（加法）
 * 注意int溢出
 */
public class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int[] count = new int[60];
        for (int t : time) {
            count[t % 60]++;
        }
        long ans = (long) count[0] * (count[0] - 1) / 2 + (long) count[30] * (count[30] - 1) / 2;
        for (int i = 1; i < 30; i++) {
            ans += count[i] * count[60 - i];
        }
        return (int) ans;
    }
}
