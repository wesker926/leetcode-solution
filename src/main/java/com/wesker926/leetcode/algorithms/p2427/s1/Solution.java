package com.wesker926.leetcode.algorithms.p2427.s1;

/**
 * @author wesker.gh
 * @date 2023/4/5
 * @description 枚举
 */
public class Solution {
    public int commonFactors(int a, int b) {
        int gcd = gcd(a, b), ans = 0;
        for (int i = 1; i <= Math.sqrt(gcd); i++) {
            ans += (gcd % i == 0) ? (i * i == gcd ? 1 : 2) : 0;
        }
        return ans;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
