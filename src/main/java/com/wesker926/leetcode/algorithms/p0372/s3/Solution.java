package com.wesker926.leetcode.algorithms.p0372.s3;

/**
 * @author wesker.gh
 * @date 2021/12/5
 * @description 欧拉降幂（欧拉-费马定理）
 * (a ^ b) % c = (a ^ (b % phi(c))) % c
 */
public class Solution {

    private final static int MOD = 1337;

    /**
     * 欧拉函数
     */
    private final static int PHI = 1140;

    public int superPow(int a, int[] b) {
        int mb = 0;
        for (int i : b) {
            mb = (mb * 10 + i) % PHI;
        }
        return pow(a % MOD, mb);
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
