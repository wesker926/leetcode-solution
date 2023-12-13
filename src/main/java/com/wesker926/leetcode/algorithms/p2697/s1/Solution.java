package com.wesker926.leetcode.algorithms.p2697.s1;

/**
 * @author wesker.gh
 * @date 2023/12/13
 * @description 双指针
 */
public class Solution {
    public String makeSmallestPalindrome(String s) {
        char[] cs = s.toCharArray();
        for (int i = 0, j = cs.length - 1; i < j; i++, j--) {
            if (cs[i] != cs[j]) cs[i] = cs[j] = (char) Math.min(cs[i], cs[j]);
        }
        return new String(cs);
    }
}
