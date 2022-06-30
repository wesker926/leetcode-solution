package com.wesker926.leetcode.algorithms.p1175.s1;

/**
 * @author wesker.gh
 * @date 2022/6/30
 * @description 排列组合
 */
public class Solution {

    private static final int MOD = (int) (1e9 + 7);

    private static final int[] PRIME_COUNT;

    static {
        int[] primes = new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97};
        PRIME_COUNT = new int[101];
        for (int i = 1, j = 0; i < PRIME_COUNT.length; i++) {
            PRIME_COUNT[i] = PRIME_COUNT[i - 1];
            if (j < primes.length && i == primes[j]) {
                PRIME_COUNT[i]++;
                j++;
            }
        }
    }

    public int numPrimeArrangements(int n) {
        return (int) ((factorial(PRIME_COUNT[n]) * factorial(n - PRIME_COUNT[n])) % MOD);
    }

    private long factorial(int n) {
        long ans = 1;
        for (int i = 1; i <= n; i++) {
            ans = (ans * i) % MOD;
        }
        return ans;
    }
}
