package com.wesker926.leetcode.algorithms.p0762.s2;

/**
 * @author wesker.gh
 * @date 2022/4/5
 * @description 二进制找质数
 */
public class Solution {

    /**
     * 665772
     * 2, 3, 5, 7, 11, 13, 17, 19
     */
    private static final int PRIME_BIT = 0b00000000000010100010100010101100;

    public int countPrimeSetBits(int left, int right) {
        int ans = 0;
        for (int i = left; i <= right; i++) {
            if ((PRIME_BIT & (1 << Integer.bitCount(i))) != 0) {
                ans++;
            }
        }
        return ans;
    }
}
