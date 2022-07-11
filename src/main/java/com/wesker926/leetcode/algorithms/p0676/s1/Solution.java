package com.wesker926.leetcode.algorithms.p0676.s1;

/**
 * @author wesker.gh
 * @date 2022/7/11
 * @description Trie + DFS
 * 也可纯Trie，会更慢
 */
public class Solution {

    private final Trie trie;

    /**
     * Your MagicDictionary object will be instantiated and called as such:
     * MagicDictionary obj = new MagicDictionary();
     * obj.buildDict(dictionary);
     * boolean param_2 = obj.search(searchWord);
     */
    public Solution() {
        trie = new Trie();
    }

    public void buildDict(String[] dictionary) {
        for (String word : dictionary) {
            trie.addWord(word);
        }
    }

    public boolean search(String searchWord) {
        return trie.search(searchWord);
    }

    private static class Trie {

        private final TrieNode root = new TrieNode();

        void addWord(String word) {
            TrieNode cur = root;
            for (char c : word.toCharArray()) {
                int idx = c - 'a';
                if (cur.children[idx] == null) {
                    cur.children[idx] = new TrieNode();
                }
                cur = cur.children[idx];
            }
            cur.isWord = true;
        }

        boolean search(String query) {
            return dfs(query.toCharArray(), 0, root, true);
        }

        boolean dfs(char[] query, int idx, TrieNode cur, boolean canModify) {
            if (cur == null) {
                return false;
            }
            if (idx == query.length) {
                return cur.isWord && !canModify;
            }
            for (int i = 0; i < cur.children.length; i++) {
                boolean nxt = false;
                if (query[idx] - 'a' == i) {
                    nxt = dfs(query, idx + 1, cur.children[i], canModify);
                } else if (canModify) {
                    nxt = dfs(query, idx + 1, cur.children[i], false);
                }
                if (nxt) {
                    return true;
                }
            }
            return false;
        }
    }

    private static class TrieNode {

        boolean isWord;

        TrieNode[] children;

        TrieNode() {
            this.isWord = false;
            this.children = new TrieNode[26];
        }
    }
}
