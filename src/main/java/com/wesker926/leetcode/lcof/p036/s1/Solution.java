package com.wesker926.leetcode.lcof.p036.s1;

/**
 * @author wesker.gh
 * @date 2022/4/13
 * @description DFS
 */
public class Solution {
    public Node treeToDoublyList(Node root) {
        Node tail = dfs(root, null), head = tail;
        if (head != null) {
            while (head.left != null) {
                head = head.left;
            }
            head.left = tail;
            tail.right = head;
        }
        return head;
    }

    private Node dfs(Node cur, Node pre) {
        if (cur == null) {
            return pre;
        }
        pre = dfs(cur.left, pre);
        if (pre != null) {
            pre.right = cur;
            cur.left = pre;
        }
        return dfs(cur.right, cur);
    }

    private static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }
}
