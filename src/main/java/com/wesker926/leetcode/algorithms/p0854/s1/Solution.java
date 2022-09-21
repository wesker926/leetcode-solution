package com.wesker926.leetcode.algorithms.p0854.s1;

import java.util.*;

/**
 * @author wesker.gh
 * @date 2022/9/21
 * @description BFS + 剪枝
 * 注：不剪枝就超时
 */
public class Solution {
    public int kSimilarity(String s1, String s2) {
        Set<String> set = new HashSet<>();
        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(node -> node.count));
        queue.offer(new Node(reduce(s1, s2), 0));
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            int l = cur.s.length();
            if (l == 0) {
                return cur.count;
            }
            if (set.contains(cur.s)) {
                continue;
            }
            set.add(cur.s);
            for (int i = 0, diff = s2.length() - l; i < l; i++) {
                if (cur.s.charAt(i) == s2.charAt(i + diff)) {
                    continue;
                }
                if (cur.s.charAt(i) == s2.charAt(diff)) {
                    char[] cs = cur.s.toCharArray();
                    cs[i] = cs[0];
                    cs[0] = s2.charAt(diff);
                    queue.offer(new Node(reduce(new String(cs), s2), cur.count + 1));
                }
            }
        }
        return -1;
    }

    private String reduce(String s1, String s2) {
        int m = s1.length(), n = s2.length(), subIdx = 0;
        for (; subIdx < m; subIdx++) {
            if (s1.charAt(subIdx) != s2.charAt(subIdx + n - m)) {
                break;
            }
        }
        return s1.substring(subIdx);
    }

    private static class Node {

        String s;

        int count;

        Node(String s, int count) {
            this.s = s;
            this.count = count;
        }
    }
}
