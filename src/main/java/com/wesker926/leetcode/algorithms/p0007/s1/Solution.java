package com.wesker926.leetcode.algorithms.p0007.s1;

/**
 * @author wesker.gh
 * @date 2022/4/21
 * @description 模拟（无需判断 ans == MAX）
 */
public class Solution {

    private static final int MAX = Integer.MAX_VALUE / 10;

    public int reverse(int x) {
        int ans = 0;
        boolean sign = x >= 0;
        for (x = Math.abs(x); x > 0; x /= 10) {
            if (ans > MAX) {
                return 0;
            } else {
                ans = ans * 10 + (x % 10);
            }
        }
        return sign ? ans : -ans;
    }
}
