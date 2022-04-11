package com.wesker926.leetcode.algorithms.p0357.s1;

/**
 * @author wesker.gh
 * @date 2022/4/11
 * @description DP排列组合（递归）
 */
public class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        return n == 0 ? 1 : 9 * permutations(9, n - 1) + countNumbersWithUniqueDigits(n - 1);
    }

    private int permutations(int a, int n) {
        int ans = 1;
        for (; n > 0; n--) {
            ans *= (a--);
        }
        return ans;
    }
}
