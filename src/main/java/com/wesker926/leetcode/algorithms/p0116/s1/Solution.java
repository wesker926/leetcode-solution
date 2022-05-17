package com.wesker926.leetcode.algorithms.p0116.s1;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author wesker.gh
 * @date 2022/5/17
 * @description BFS - 队列
 * 二叉树通用写法
 */
public class Solution {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Queue<Node> queue = new LinkedList<>(List.of(root));
        for (int layer = 1; !queue.isEmpty(); ) {
            Node cur = queue.poll();
            if (cur.left != null) {
                queue.offer(cur.left);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
            }
            if (--layer == 0) {
                layer = queue.size();
            } else {
                cur.next = queue.peek();
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
