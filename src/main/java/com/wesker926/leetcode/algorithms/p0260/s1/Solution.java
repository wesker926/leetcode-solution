package com.wesker926.leetcode.algorithms.p0260.s1;

/**
 * @author wesker.gh
 * @date 2021/10/30
 * @description xor
 */
public class Solution {

    public int[] singleNumber(int[] nums) {
        int xor = 0, bit = 0;
        for (int n : nums) {
            xor ^= n;
        }
        bit = (xor & (xor - 1)) ^ xor;

        int[] result = new int[2];
        for (int n : nums) {
            result[(n & bit) != 0 ? 0 : 1] ^= n;
        }
        return result;
    }
}
