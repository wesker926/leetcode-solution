package com.wesker926.leetcode.algorithms.p0520.s1;

/**
 * @author wesker.gh
 * @date 2021/11/13
 * @description 遍历
 */
public class Solution {
    public boolean detectCapitalUse(String word) {
        boolean first = Character.isUpperCase(word.charAt(0));
        int up = 0;
        for (char c : word.toCharArray()) {
            if (Character.isUpperCase(c)) {
                up++;
            }
        }
        return (first && up == word.length()) || (first && up == 1) || (!first && up == 0);
    }
}
