package com.wesker926.leetcode.algorithms.p0559.s2;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author wesker.gh
 * @date 2021/11/21
 * @description bfs
 */
public class Solution {
    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }

        Queue<Node> queue = new LinkedList<>() {{
            add(root);
        }};
        int max = 0, count = queue.size();
        Node cur;
        while (count > 0) {
            cur = queue.poll();
            for (Node child : cur.children) {
                queue.offer(child);
            }
            count--;
            if (count == 0) {
                count = queue.size();
                max++;
            }
        }
        return max;
    }

    private static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
