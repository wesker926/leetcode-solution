package com.wesker926.leetcode.algorithms.p0790.s1;

/**
 * @author wesker.gh
 * @date 2022/11/12
 * @description DP
 * a为上上轮全部铺满的；b1为上轮全部铺满的；b2为上轮缺一角的。
 */
public class Solution {

    private static final int MOD = (int) 1e9 + 7;

    public int numTilings(int n) {
        if (n < 3) {
            return n;
        }
        long a = 1, b1 = 2, b2 = 2;
        for (int i = 3; i <= n; i++) {
            long t1 = (a + b1 + b2) % MOD, t2 = (a * 2 + b2) % MOD;
            a = b1;
            b1 = t1;
            b2 = t2;
        }
        return (int) b1;
    }
}
