package com.wesker926.leetcode.algorithms.p0357.s2;

/**
 * @author wesker.gh
 * @date 2022/4/11
 * @description DP排列组合（迭代）
 */
public class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        int ans = 1, mul = 9;
        for (int i = 9; i > 9 - n; i--) {
            ans += mul;
            mul *= i;
        }
        return ans;
    }
}
