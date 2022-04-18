package com.wesker926.leetcode.lcof.p056_1.s1;

/**
 * @author wesker.gh
 * @date 2022/4/18
 * @description xor + lowBit
 */
public class Solution {
    public int[] singleNumbers(int[] nums) {
        int xor = 0, a = 0, b = 0, lowBit;
        for (int num : nums) {
            xor ^= num;
        }
        lowBit = xor & (-xor);
        for (int num : nums) {
            if ((num & lowBit) == 0) {
                a ^= num;
            } else {
                b ^= num;
            }
        }
        return new int[]{a, b};
    }
}
