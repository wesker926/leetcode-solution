package com.wesker926.leetcode.algorithms.p0677.s1;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wesker.gh
 * @date 2021/11/14
 * @description trie字典树
 */
public class Solution {

    /**
     * Your MapSum object will be instantiated and called as such:
     * MapSum obj = new MapSum();
     * obj.insert(key,val);
     * int param_2 = obj.sum(prefix);
     */
    private static class MapSum {

        private final Map<String, Integer> map;

        private final Node root;

        public MapSum() {
            this.map = new HashMap<>();
            this.root = new Node(-1);
        }

        public void insert(String key, int val) {
            int nv = val;
            if (map.containsKey(key)) {
                nv -= map.get(key);
            }
            map.put(key, val);

            int idx;
            Node cur = root;
            for (char c : key.toCharArray()) {
                idx = c - 'a';
                if (cur.children[idx] == null) {
                    cur.children[idx] = new Node(nv);
                } else {
                    cur.children[idx].val += nv;
                }
                cur = cur.children[idx];
            }
        }

        public int sum(String prefix) {
            int idx;
            Node cur = root;
            for (char c : prefix.toCharArray()) {
                idx = c - 'a';
                cur = cur.children[idx];
                if (cur == null) {
                    return 0;
                }
            }
            return cur.val;
        }
    }

    private static class Node {

        int val;

        Node[] children;

        Node(int val) {
            this.val = val;
            this.children = new Node[26];
        }
    }
}
