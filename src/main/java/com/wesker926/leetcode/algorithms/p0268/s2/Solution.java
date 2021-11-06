package com.wesker926.leetcode.algorithms.p0268.s2;

/**
 * @author wesker.gh
 * @date 2021/11/6
 * @description 异或运算
 */
public class Solution {
    public int missingNumber(int[] nums) {
        int xor = 0;
        for (int i = 0; i < nums.length; i++) {
            xor ^= i ^ nums[i];
        }
        return xor ^ nums.length;
    }
}
