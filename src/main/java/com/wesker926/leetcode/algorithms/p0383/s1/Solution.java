package com.wesker926.leetcode.algorithms.p0383.s1;

/**
 * @author wesker.gh
 * @date 2021/12/4
 * @description 字母表
 */
public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (magazine.length() < ransomNote.length()) {
            return false;
        }

        int[] map = new int[26];
        for (char c : magazine.toCharArray()) {
            map[c - 'a']++;
        }

        for (char c : ransomNote.toCharArray()) {
            if ((map[c - 'a']--) <= 0) {
                return false;
            }
        }
        return true;
    }
}
