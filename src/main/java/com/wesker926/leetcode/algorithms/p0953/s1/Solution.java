package com.wesker926.leetcode.algorithms.p0953.s1;

/**
 * @author wesker.gh
 * @date 2022/5/17
 * @description bucket + 遍历
 */
public class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] dictionary = new int[26];
        for (int i = 0; i < order.length(); i++) {
            dictionary[order.charAt(i) - 'a'] = i;
        }
        for (int i = 1; i < words.length; i++) {
            if (!compare(words[i - 1], words[i], dictionary)) {
                return false;
            }
        }
        return true;
    }

    private boolean compare(String f, String s, int[] dictionary) {
        for (int i = 0; i < f.length(); i++) {
            if (s.length() <= i || dictionary[f.charAt(i) - 'a'] > dictionary[s.charAt(i) - 'a']) {
                return false;
            } else if (dictionary[f.charAt(i) - 'a'] < dictionary[s.charAt(i) - 'a']) {
                return true;
            }
        }
        return true;
    }
}
