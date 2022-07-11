package com.wesker926.leetcode.algorithms.p0676.s2;

/**
 * @author wesker.gh
 * @date 2022/7/11
 * @description 暴力枚举
 * 比Trie更快
 */
public class Solution {

    private String[] dictionary;

    public Solution() {
    }

    public void buildDict(String[] dictionary) {
        this.dictionary = dictionary;
    }

    public boolean search(String searchWord) {
        for (String word : dictionary) {
            if (word.length() != searchWord.length()) {
                continue;
            }
            int diff = 0;
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) != searchWord.charAt(i)) {
                    diff++;
                }
                if (diff > 1) {
                    break;
                }
            }
            if (diff == 1) {
                return true;
            }
        }
        return false;
    }
}
