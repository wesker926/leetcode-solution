package com.wesker926.leetcode.algorithms.p2559.s1;

/**
 * @author wesker.gh
 * @date 2023/6/2
 * @description 前缀和
 */
public class Solution {

    private static final boolean[] VOWEL = getVowel();

    private static boolean[] getVowel() {
        boolean[] vowel = new boolean[26];
        for (char c : new char[]{'a', 'e', 'i', 'o', 'u'}) vowel[c - 'a'] = true;
        return vowel;
    }

    public int[] vowelStrings(String[] words, int[][] queries) {
        int[] pre = new int[words.length + 1];
        for (int i = 0; i < words.length; i++) {
            pre[i + 1] = pre[i] + (VOWEL[words[i].charAt(0) - 'a'] &&
                    VOWEL[words[i].charAt(words[i].length() - 1) - 'a'] ? 1 : 0);
        }
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) ans[i] = pre[queries[i][1] + 1] - pre[queries[i][0]];
        return ans;
    }
}
