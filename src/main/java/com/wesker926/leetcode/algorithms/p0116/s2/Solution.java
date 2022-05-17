package com.wesker926.leetcode.algorithms.p0116.s2;

/**
 * @author wesker.gh
 * @date 2022/5/17
 * @description BFS无队列
 * 仅适用于满二叉树（完美二叉树）
 * 普通二叉树需要修改，见p0117
 */
public class Solution {
    public Node connect(Node root) {
        for (Node first = root, cur = first; cur != null; ) {
            if (cur.left != null) {
                cur.left.next = cur.right;
                cur.right.next = cur.next == null ? null : cur.next.left;
            }
            if (cur.next == null) {
                first = first.left;
                cur = first;
            } else {
                cur = cur.next;
            }
        }
        return root;
    }

    private static class Node {

        public int val;

        public Node left;

        public Node right;

        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
