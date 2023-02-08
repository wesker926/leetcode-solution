package com.wesker926.leetcode.algorithms.p1233.s1;

import java.util.*;

/**
 * @author wesker.gh
 * @date 2023/2/8
 * @description 字典树
 */
public class Solution {
    public List<String> removeSubfolders(String[] folder) {
        Trie trie = new Trie();
        for (String val : folder) {
            trie.add(val);
        }
        return trie.getAll();
    }

    private static class Trie {

        private final TrieNode root;

        Trie() {
            root = new TrieNode(null);
        }

        void add(String val) {
            TrieNode cur = root;
            String[] keys = val.split("/");
            for (int i = 1; i < keys.length; i++) {
                if (cur.val != null) {
                    return;
                }
                cur = cur.children.computeIfAbsent(keys[i], k -> new TrieNode(null));
            }
            cur.val = val;
            cur.children.clear();
        }

        List<String> getAll() {
            return dfs(root, new ArrayList<>());
        }

        List<String> dfs(TrieNode node, List<String> res) {
            if (node.val != null) {
                res.add(node.val);
                return res;
            }
            for (TrieNode child : node.children.values()) {
                dfs(child, res);
            }
            return res;
        }
    }

    private static class TrieNode {

        String val;

        Map<String, TrieNode> children;

        TrieNode(String val) {
            this.val = val;
            this.children = new HashMap<>();
        }
    }
}
