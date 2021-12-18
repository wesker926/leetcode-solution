package com.wesker926.leetcode.algorithms.p0430.s1;

/**
 * @author wesker.gh
 * @date 2021/12/18
 * @description dfs
 */
public class Solution {
    public Node flatten(Node head) {
        dfs(head);
        return head;
    }

    private Node dfs(Node head) {
        Node last = head, t;
        for (; head != null; last = head, head = head.next) {
            if (head.child == null) {
                continue;
            }

            t = dfs(head.child);
            t.next = head.next;
            if (t.next != null) {
                t.next.prev = t;
            }
            head.next = head.child;
            head.child.prev = head;
            head.child = null;
            head = t;
        }
        return last;
    }

    private static class Node {
        public int val;

        public Node prev;

        public Node next;

        public Node child;
    }
}
