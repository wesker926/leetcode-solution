package com.wesker926.leetcode.algorithms.p1759.s1;

/**
 * @author wesker.gh
 * @date 2022/12/26
 * @description 滑动窗口
 */
public class Solution {

    private static final int MOD = (int) 1e9 + 7;

    public int countHomogenous(String s) {
        long ans = 0;
        for (int i = 0, j = 0; j <= s.length(); j++) {
            if (j == s.length() || s.charAt(j) != s.charAt(i)) {
                ans += (long) (j - i) * (j - i + 1) / 2;
                i = j;
            }
        }
        return (int) (ans % MOD);
    }
}
