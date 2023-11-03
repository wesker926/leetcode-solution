package com.wesker926.leetcode.algorithms.p0117.s1;

/**
 * @author wesker.gh
 * @date 2022/5/17
 * @description BFS无队列
 * 普通二叉树版本
 */
public class Solution {
    public Node connect(Node root) {
        for (Node cur = root, nxtHead = new Node(), nxt = nxtHead; cur != null; ) {
            if (cur.left != null || cur.right != null) {
                if (cur.left != null && cur.right != null) cur.left.next = cur.right;
                nxt.next = cur.left != null ? cur.left : cur.right;
                nxt = cur.right != null ? cur.right : cur.left;
            }
            if (cur.next != null) cur = cur.next;
            else {
                cur = nxtHead.next;
                nxtHead.next = null;
                nxt = nxtHead;
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
