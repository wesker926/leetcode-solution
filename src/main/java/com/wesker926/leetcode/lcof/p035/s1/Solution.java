package com.wesker926.leetcode.lcof.p035.s1;

/**
 * @author wesker.gh
 * @date 2021/10/28
 * @description copy random linked list
 */
public class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        Node cur = head, nxt;
        for (; cur != null; cur = nxt.next) {
            nxt = new Node(cur.val);
            nxt.next = cur.next;
            cur.next = nxt;
        }

        cur = head;
        for (; cur != null; cur = cur.next.next) {
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            }
        }

        Node result = head.next;
        cur = head;
        nxt = result;
        for (; cur != null; cur = cur.next, nxt = nxt.next) {
            cur.next = nxt.next;
            if (cur.next != null) {
                nxt.next = cur.next.next;
            }
        }
        return result;
    }

    private static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
