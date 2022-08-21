package com.wesker926.leetcode.algorithms.p1455.s1;

/**
 * @author wesker.gh
 * @date 2022/8/21
 * @description 双指针遍历
 */
public class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        for (int i = 0, j = 0, count = 1; i < sentence.length(); i++) {
            if (sentence.charAt(i) == ' ') {
                j = 0;
                count++;
                continue;
            }
            if (j == -1) {
                continue;
            }
            if (sentence.charAt(i) == searchWord.charAt(j)) {
                j++;
                if (j == searchWord.length()) {
                    return count;
                }
            } else {
                j = -1;
            }
        }
        return -1;
    }
}
