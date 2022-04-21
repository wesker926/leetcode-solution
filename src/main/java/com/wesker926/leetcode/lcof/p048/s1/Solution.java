package com.wesker926.leetcode.lcof.p048.s1;

/**
 * @author wesker.gh
 * @date 2022/4/15
 * @description 双指针（同主站-p0003）
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        char[] cs = s.toCharArray();
        boolean[] set = new boolean[256];
        int ans = 0, i= 0, j = 0;
        for (; j < cs.length; j++) {
            if (set[cs[j]]) {
                ans = Math.max(ans, j - i);
                for (;cs[i] != cs[j];i++) {
                    set[cs[i]] = false;
                }
                i++;
            } else {
                set[cs[j]] = true;
            }
        }
        return Math.max(ans, j - i);
    }
}
