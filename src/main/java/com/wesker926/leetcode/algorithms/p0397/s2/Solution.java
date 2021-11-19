package com.wesker926.leetcode.algorithms.p0397.s2;

/**
 * @author wesker.gh
 * @date 2021/11/19
 * @description 贪心
 */
public class Solution {
    public int integerReplacement(int n) {
        int c = 0;
        while (n > 1) {
            if ((n & 1) == 0) {
                c++;
                n >>= 1;
                continue;
            }

            if (((n >> 1) & 1) == 0) {
                n >>= 1;
            } else {
                if (n == 3) {
                    return c + 2;
                }
                n = (n >> 1) + 1;
            }
            c += 2;
        }
        return c;
    }
}
