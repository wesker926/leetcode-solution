package com.wesker926.leetcode.algorithms.p0372.s1;

/**
 * @author wesker.gh
 * @date 2021/12/5
 * @description 倒序
 * a ^ b = a ^ (bi * (10 ^ n-1-i)) * ... = (a ^ (10 ^ n-1-i)) ^ bi ...
 */
public class Solution {

    private final static int MOD = 1337;

    public int superPow(int a, int[] b) {
        long result = 1;
        for (int i = b.length - 1; i >= 0; i--) {
            result = (result * pow(a, b[i])) % MOD;
            a = pow(a, 10);
        }
        return (int) result;
    }

    private int pow(long a, int b) {
        long result = 1;
        for (; b != 0; b >>= 1, a = (a * a) % MOD) {
            if ((b & 1) != 0) {
                result = (result * a) % MOD;
            }
        }
        return (int) result;
    }
}
