package com.wesker926.leetcode.lcof.p010_2.s1;

/**
 * @author wesker.gh
 * @date 2022/3/29
 * @description DP（同主站-p0070）
 */
public class Solution {

    private static final int MOD = 1000000007;

    public int numWays(int n) {
        int a = 1, b = 1;
        for (int t; n > 0; n--) {
            t = b;
            b = (a + b) % MOD;
            a = t;
        }
        return a;
    }
}
