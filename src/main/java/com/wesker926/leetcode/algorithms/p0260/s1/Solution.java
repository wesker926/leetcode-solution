package com.wesker926.leetcode.algorithms.p0260.s1;

/**
 * @author wesker.gh
 * @date 2021/10/30
 * @description xor & lowbit
 */
public class Solution {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for (int num : nums) xor ^= num;
        int lowbit = xor & (-xor);
        int[] result = new int[2];
        for (int num : nums) result[(num & lowbit) != 0 ? 0 : 1] ^= num;
        return result;
    }
}
