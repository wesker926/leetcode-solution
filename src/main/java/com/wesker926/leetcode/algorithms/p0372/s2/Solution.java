package com.wesker926.leetcode.algorithms.p0372.s2;

/**
 * @author wesker.gh
 * @date 2021/12/5
 * @description 正序（秦九韶算法）
 * a ^ b = a ^ (bi * (10 ^ n-1-i)) * ... = (a ^ bi) ^ (10 ^ n-1-i)
 */
public class Solution {

    private final static int MOD = 1337;

    public int superPow(int a, int[] b) {
        long result = 1;
        for (int i : b) {
            result = ((long) pow(result, 10) * pow(a, i)) % MOD;
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
