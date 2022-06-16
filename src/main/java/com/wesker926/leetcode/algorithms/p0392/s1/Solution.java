package com.wesker926.leetcode.algorithms.p0392.s1;

/**
 * @author wesker.gh
 * @date 2022/6/16
 * @description 双指针
 */
public class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s.length() > t.length()) {
            return false;
        }
        int i = 0;
        for (int j = 0; i < s.length() && j < t.length(); j++) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
        }
        return i == s.length();
    }
}
