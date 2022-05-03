package com.wesker926.leetcode.algorithms.p0066.s1;

/**
 * @author wesker.gh
 * @date 2022/5/3
 * @description 遍历
 */
public class Solution {
    public int[] plusOne(int[] digits) {
        digits[digits.length - 1]++;
        for (int i = digits.length - 2; i >= 0 && digits[i + 1] > 9; i--) {
            digits[i + 1] = 0;
            digits[i]++;
        }
        if (digits[0] == 10) {
            digits = new int[digits.length + 1];
            digits[0] = 1;
        }
        return digits;
    }
}
