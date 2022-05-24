package com.wesker926.leetcode.algorithms.p0143.s1;

/**
 * @author wesker.gh
 * @date 2022/5/24
 * @description 找链表中点 + 链表逆序 + 交替合并链表
 * 注：也可用快慢指针找链表中点，其实区别不大。
 */
public class Solution {
    public void reorderList(ListNode head) {
        int len = getLength(head);
        if (len < 3) {
            return;
        }
        ListNode tail, cur = head, nxt;
        for (int i = 1; i < (len + 1) / 2; i++) {
            cur = cur.next;
        }
        tail = cur.next;
        cur.next = null;
        for (cur = head, tail = reverse(tail); cur != null && tail != null; cur = nxt) {
            nxt = cur.next;
            cur.next = tail;
            tail = tail.next;
            cur.next.next = nxt;
        }
    }

    private int getLength(ListNode node) {
        int len = 0;
        for (; node != null; node = node.next) {
            len++;
        }
        return len;
    }

    private ListNode reverse(ListNode head) {
        if (head.next == null) {
            return head;
        }
        head = new ListNode(0, head);
        for (ListNode cur = head.next, nxt = cur.next; nxt != null; nxt = cur.next) {
            cur.next = nxt.next;
            nxt.next = head.next;
            head.next = nxt;
        }
        return head.next;
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
