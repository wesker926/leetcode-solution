package com.wesker926.leetcode.algorithms.p0878.s1;

/**
 * @author wesker.gh
 * @date 2022/11/22
 * @description 数学
 * 难
 */
public class Solution {

    public static final int MOD = (int) 1e9 + 7;

    public int nthMagicalNumber(int n, int a, int b) {
        int c = lcm(a, b), m = c / a + c / b - 1, r = n % m;
        int res = (int) (((long) c * (n / m)) % MOD);
        if (r == 0) {
            return res;
        }
        int addA = a, addB = b;
        for (int i = 0; i < r - 1; i++) {
            if (addA < addB) {
                addA += a;
            } else {
                addB += b;
            }
        }
        return (res + Math.min(addA, addB) % MOD) % MOD;
    }

    private int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    private int gcd(int a, int b) {
        return b != 0 ? gcd(b, a % b) : a;
    }
}
