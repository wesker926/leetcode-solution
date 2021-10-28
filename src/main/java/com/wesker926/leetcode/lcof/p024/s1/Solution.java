package com.wesker926.leetcode.lcof.p024.s1;

/**
 * @author wesker.gh
 * @date 2021/10/28
 * @description reverse linked list
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode cur = new ListNode(-1);
        cur.next = head;
        head = cur;

        cur = head.next;
        ListNode nxt = cur.next;

        for (; nxt != null; nxt = cur.next) {
            cur.next = nxt.next;
            nxt.next = head.next;
            head.next = nxt;
        }
        return head.next;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
