package com.wesker926.leetcode.lcof.p014_2.s1;

/**
 * @author wesker.gh
 * @date 2022/3/31
 * @description p014_1 + 快速幂
 */
public class Solution {

    private static final int MOD = 1000000007;

    public int cuttingRope(int n) {
        if (n < 4) {
            return n - 1;
        }
        int mod = n % 3, count3 = n / 3;
        if (mod == 1) {
            mod = 4;
            count3--;
        }
        return (int) ((pow(3, count3) * (mod == 0 ? 1 : mod)) % MOD);
    }

    private long pow(long a, int b) {
        a %= MOD;
        return b == 0 ? 1 : (pow(a * a, b >> 1) * ((b & 1) == 0 ? 1 : a)) % MOD;
    }
}
