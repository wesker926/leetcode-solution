package com.wesker926.leetcode.algorithms.p0061.s1;

/**
 * @author wesker.gh
 * @date 2022/5/2
 * @description 环
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null || head.next == null) {
            return head;
        }
        int len = 1;
        ListNode tail = head;
        for (; tail.next != null; tail = tail.next) {
            len++;
        }
        if ((k %= len) == 0) {
            return head;
        }
        tail.next = head;
        for (int i = len - k; i > 0; i--) {
            tail = tail.next;
        }
        head = tail.next;
        tail.next = null;
        return head;
    }

    private static class ListNode {

        int val;

        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
