package com.wesker926.leetcode.algorithms.p0762.s1;

import java.util.Arrays;

/**
 * @author wesker.gh
 * @date 2022/4/5
 * @description 二分找质数
 */
public class Solution {

    private static final int[] PRIMES = new int[]{2, 3, 5, 7, 11, 13, 17, 19};

    public int countPrimeSetBits(int left, int right) {
        int ans = 0;
        for (int i = left; i <= right; i++) {
            if (isPrime(bitCount(i))) {
                ans++;
            }
        }
        return ans;
    }

    private boolean isPrime(int a) {
        return Arrays.binarySearch(PRIMES, a) >= 0;
    }

    private int bitCount(int a) {
        int c = 0;
        for (; a != 0; a &= a - 1) {
            c++;
        }
        return c;
    }
}
