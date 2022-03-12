package com.wesker926.leetcode.algorithms.p0590.s2;

import java.util.LinkedList;
import java.util.List;

/**
 * @author wesker.gh
 * @date 2022/3/12
 * @description DFS 迭代
 */
public class Solution {
    public List<Integer> postorder(Node root) {
        LinkedList<Integer> result = new LinkedList<>();
        if (root == null) {
            return result;
        }

        LinkedList<Node> stack = new LinkedList<>();
        stack.push(root);
        Node cur;
        while (!stack.isEmpty()) {
            cur = stack.pop();
            result.addFirst(cur.val);
            if (cur.children != null) {
                for (Node child : cur.children) {
                    stack.push(child);
                }
            }
        }
        return result;
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
