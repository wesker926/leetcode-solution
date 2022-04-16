package com.wesker926.leetcode.algorithms.p0479.s1;

/**
 * @author wesker.gh
 * @date 2022/4/16
 * @description 枚举
 */
public class Solution {
    public int largestPalindrome(int n) {
        if (n == 1) {
            return 9;
        }
        int max = (int) Math.pow(10, n) - 1;
        for (int i = max; i >= max / 10 + 1; i--) {
            long num = i, left = i;
            // 实际结果表明，当n > 1时，总能在abba回文模式中找到答案。
            for (; left > 0; left /= 10) {
                num = num * 10 + (left % 10);
            }
            for (long j = max; j * j >= num; j--) {
                if (num % j == 0) {
                    return (int) (num % 1337);
                }
            }
        }
        return -1;
    }
}
