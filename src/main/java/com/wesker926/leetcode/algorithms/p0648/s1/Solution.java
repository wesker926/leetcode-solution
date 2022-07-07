package com.wesker926.leetcode.algorithms.p0648.s1;

import java.util.List;

/**
 * @author wesker.gh
 * @date 2022/7/7
 * @description Trie字典树
 */
public class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        TrieNode root = new TrieNode();
        for (String s : dictionary) {
            TrieNode cur = root;
            for (char c : s.toCharArray()) {
                int idx = c - 'a';
                if (cur.children[idx] == null) {
                    cur.children[idx] = new TrieNode();
                }
                cur = cur.children[idx];
            }
            cur.value = s;
        }
        StringBuilder sb = new StringBuilder();
        char[] cs = sentence.toCharArray();
        for (int i = 0, j = 0; j <= cs.length; j++) {
            if (j != cs.length && cs[j] != ' ') {
                continue;
            }
            TrieNode cur = root;
            for (int k = i; k < j && cur != null && cur.value == null; k++) {
                cur = cur.children[cs[k] - 'a'];
            }
            if (cur != null && cur.value != null) {
                sb.append(cur.value).append(' ');
            } else {
                sb.append(sentence, i, j).append(' ');
            }
            i = j + 1;
        }
        return sb.deleteCharAt(sb.length() - 1).toString();
    }

    private static class TrieNode {

        String value;

        TrieNode[] children = new TrieNode[26];
    }
}
