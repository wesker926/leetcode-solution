package com.wesker926.leetcode.algorithms.p1768.s1;

/**
 * @author wesker.gh
 * @date 2022/10/23
 * @description 交替合并
 */
public class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int i = 0, j = 0;
        for (; i < word1.length() && j < word2.length(); i++, j++) {
            sb.append(word1.charAt(i)).append(word2.charAt(j));
        }
        return sb.append(i == word1.length() ? word2.substring(j) : word1.substring(i)).toString();
    }
}
