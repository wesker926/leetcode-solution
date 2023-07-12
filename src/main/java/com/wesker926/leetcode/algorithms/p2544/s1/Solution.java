package com.wesker926.leetcode.algorithms.p2544.s1;

/**
 * @author wesker.gh
 * @date 2023/7/12
 * @description 数学
 */
public class Solution {
    public int alternateDigitSum(int n) {
        int ans = 0, mark = 1;
        for (; n > 0; n /= 10, mark = -mark) ans += mark * (n % 10);
        // return mark == 1 ? -ans : ans;
        return -mark * ans;
    }
}
