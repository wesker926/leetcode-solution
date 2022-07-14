package com.wesker926.leetcode.algorithms.p0745.s1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wesker.gh
 * @date 2022/7/14
 * @description 前后缀字典树
 * 2022.07.14时，当前测试用例效果还不错。
 */
public class Solution {

    private final Trie trie;

    /**
     * Your WordFilter object will be instantiated and called as such:
     * WordFilter obj = new WordFilter(words);
     * int param_1 = obj.f(pref,suff);
     */
    public Solution(String[] words) {
        trie = new Trie();
        for (int i = 0; i < words.length; i++) {
            trie.add(words[i].toCharArray(), i);
        }
    }

    public int f(String pref, String suff) {
        return trie.find(pref.toCharArray(), suff.toCharArray());
    }

    private static class Trie {

        private final TrieNode prefRoot = new TrieNode();

        private final TrieNode suffRoot = new TrieNode();

        void add(char[] str, int idx) {
            TrieNode prefCur = prefRoot, suffCur = suffRoot;
            for (int i = 0, j = str.length - 1; i < str.length; i++, j--) {
                int p = str[i] - 'a', s = str[j] - 'a';
                if (prefCur.children[p] == null) {
                    prefCur.children[p] = new TrieNode();
                }
                if (suffCur.children[s] == null) {
                    suffCur.children[s] = new TrieNode();
                }
                prefCur = prefCur.children[p];
                suffCur = suffCur.children[s];
                prefCur.idxList.add(idx);
                suffCur.idxList.add(idx);
            }
        }

        int find(char[] pref, char[] suff) {
            TrieNode prefCur = prefRoot, suffCur = suffRoot;
            for (int i = 0; i < pref.length && prefCur != null; i++) {
                prefCur = prefCur.children[pref[i] - 'a'];
            }
            if (prefCur == null || prefCur.idxList.isEmpty()) {
                return -1;
            }
            for (int i = suff.length - 1; i >= 0 && suffCur != null; i--) {
                suffCur = suffCur.children[suff[i] - 'a'];
            }
            if (suffCur == null || suffCur.idxList.isEmpty()) {
                return -1;
            }
            for (int i = prefCur.idxList.size() - 1, j = suffCur.idxList.size() - 1; i >= 0 && j >= 0; ) {
                if (prefCur.idxList.get(i).intValue() == suffCur.idxList.get(j)) {
                    return prefCur.idxList.get(i);
                } else if (prefCur.idxList.get(i) > suffCur.idxList.get(j)) {
                    i--;
                } else {
                    j--;
                }
            }
            return -1;
        }
    }

    private static class TrieNode {

        final List<Integer> idxList = new ArrayList<>();

        final TrieNode[] children = new TrieNode[26];
    }
}
