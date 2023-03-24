package com.wesker926.leetcode.algorithms.p1032.s1;

/**
 * @author wesker.gh
 * @date 2023/3/24
 * @description 字典树
 * 暴力解法，能过
 */
public class Solution {

    int idx;

    int[] query;

    Trie trie;

    public Solution(String[] words) {
        trie = new Trie();
        trie.add(words);
        query = new int[40000];
        idx = 0;
    }

    public boolean query(char letter) {
        query[idx++] = letter - 'a';
        return trie.hasPrefixWord(query, idx);
    }

    private static class Trie {

        TrieNode root;

        Trie() {
            root = new TrieNode(false);
        }

        void add(String[] words) {
            for (String word : words) {
                TrieNode cur = root;
                for (int i = word.length() - 1; i >= 0; i--) {
                    int ch = word.charAt(i) - 'a';
                    if (cur.children[ch] == null) {
                        cur.children[ch] = new TrieNode(false);
                    }
                    cur = cur.children[ch];
                }
                cur.isWord = true;
            }
        }

        boolean hasPrefixWord(int[] query, int idx) {
            TrieNode cur = root;
            for (int i = idx - 1; i >= 0; i--) {
                int ch = query[i];
                if (cur.children[ch] == null) {
                    return false;
                }
                cur = cur.children[ch];
                if (cur.isWord) {
                    return true;
                }
            }
            return false;
        }
    }

    private static class TrieNode {

        boolean isWord;

        TrieNode[] children;

        TrieNode(boolean isWord) {
            this.isWord = isWord;
            children = new TrieNode[26];
        }
    }
}
