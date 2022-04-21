package com.wesker926.leetcode.algorithms.p0003.s1;

/**
 * @author wesker.gh
 * @date 2022/4/20
 * @description 双指针（同lcof-p048）
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        char[] cs = s.toCharArray();
        boolean[] table = new boolean[256];
        int ans = 0, i = 0, j = 0;
        for (; j < cs.length; j++) {
            if (table[cs[j]]) {
                ans = Math.max(j - i, ans);
                for (; cs[i] != cs[j]; i++) {
                    table[cs[i]] = false;
                }
                i++;
            } else {
                table[cs[j]] = true;
            }
        }
        return Math.max(j - i, ans);
    }
}
