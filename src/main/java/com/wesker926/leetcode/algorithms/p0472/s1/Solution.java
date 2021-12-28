package com.wesker926.leetcode.algorithms.p0472.s1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author wesker.gh
 * @date 2021/12/28
 * @description 字典树 + dfs
 */
public class Solution {

    Trie t;

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        t = new Trie();
        Arrays.sort(words, Comparator.comparingInt(String::length));
        int idx = words[0].length() == 0 ? 1 : 0;

        List<String> ans = new LinkedList<>();
        for (; idx < words.length; idx++) {
            if (dfs(words[idx].toCharArray(), 0)) {
                ans.add(words[idx]);
            } else {
                t.add(words[idx]);
            }
        }
        return ans;
    }

    private boolean dfs(char[] cs, int start) {
        if (start == cs.length) {
            return true;
        }

        Node cur = t.root;
        for (int i = start; i < cs.length; i++) {
            cur = cur.children[cs[i] - 'a'];
            if (cur == null) {
                return false;
            }
            if (cur.isWord && dfs(cs, i + 1)) {
                return true;
            }
        }
        return false;
    }

    private static class Trie {

        private final Node root;

        public Trie() {
            this.root = new Node();
        }

        public void add(String s) {
            Node cur = root;
            int idx;
            for (char c : s.toCharArray()) {
                idx = c - 'a';
                if (cur.children[idx] == null) {
                    cur.children[idx] = new Node();
                }
                cur = cur.children[idx];
            }
            cur.isWord = true;
        }
    }

    private static class Node {

        private final Node[] children;

        private boolean isWord;

        public Node() {
            this.children = new Node[26];
            this.isWord = false;
        }
    }
}
