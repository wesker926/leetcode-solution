package com.wesker926.leetcode.algorithms.p1255.s2;

/**
 * @author wesker.gh
 * @date 2023/2/26
 * @description DFS回溯
 * 效果更好
 */
public class Solution {
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int[] has = new int[26];
        for (char letter : letters) {
            has[letter - 'a']++;
        }
        return dfs(words, has, score, 0);
    }

    private int dfs(String[] words, int[] has, int[] score, int i) {
        if (i == words.length) {
            return 0;
        }
        int left = dfs(words, has, score, i + 1), right = 0, cur = 0;

        boolean ok = true;
        String word = words[i];
        for (int j = 0; j < word.length(); j++) {
            if (has[word.charAt(j) - 'a']-- == 0) {
                ok = false;
            }
            cur += score[word.charAt(j) - 'a'];
        }
        if (ok) {
            right = dfs(words, has, score, i + 1) + cur;
        }

        for (int j = 0; j < word.length(); j++) {
            has[word.charAt(j) - 'a']++;
        }
        return Math.max(left, right);
    }
}
