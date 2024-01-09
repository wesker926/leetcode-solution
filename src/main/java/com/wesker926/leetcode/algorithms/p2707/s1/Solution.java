package com.wesker926.leetcode.algorithms.p2707.s1;

/**
 * @author wesker.gh
 * @date 2024/1/9
 * @description DP +Trie
 * 字典树是优化项
 */
public class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        Node root = new Node();
        for (String word : dictionary) {
            Node cur = root;
            for (int i = word.length() - 1; i >= 0; i--) {
                int c = word.charAt(i) - 'a';
                if (cur.nxt == null) cur.nxt = new Node[26];
                if (cur.nxt[c] == null) cur.nxt[c] = new Node();
                cur = cur.nxt[c];
            }
            cur.word = true;
        }

        int n = s.length();
        int[] dp = new int[n + 1];
        for (int i = 0; i < n; i++) {
            Node cur = root;
            dp[i + 1] = dp[i] + 1;
            for (int j = i; j >= 0; j--) {
                int c = s.charAt(j) - 'a';
                if (cur.nxt == null || cur.nxt[c] == null) break;
                cur = cur.nxt[c];
                if (cur.word) dp[i + 1] = Math.min(dp[i + 1], dp[j]);
            }
        }
        return dp[n];
    }

    private static class Node {

        boolean word;

        Node[] nxt;
    }
}
