package com.wesker926.leetcode.algorithms.p0005.s1;

/**
 * @author wesker.gh
 * @date 2022/4/20
 * @description 中心扩展
 */
public class Solution {
    public String longestPalindrome(String s) {
        char[] cs = s.toCharArray();
        int[] ans = new int[]{0, 0};
        for (int i = 0; i < cs.length; i++) {
            int cur = Math.max(palindromeLen(cs, i, i), palindromeLen(cs, i, i + 1));
            if (ans[1] - ans[0] < cur) {
                ans[0] = i - (cur - 1) / 2;
                ans[1] = i + cur / 2 + 1;
            }
        }
        return new String(cs, ans[0], ans[1] - ans[0]);
    }

    private int palindromeLen(char[] cs, int i, int j) {
        for (; i >= 0 && j < cs.length && cs[i] == cs[j]; i--, j++) {
        }
        return j - i - 1;
    }
}
