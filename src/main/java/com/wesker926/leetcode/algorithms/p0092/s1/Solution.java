package com.wesker926.leetcode.algorithms.p0092.s1;

/**
 * @author wesker.gh
 * @date 2022/5/9
 * @description 一次遍历（头插法）
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null || left == right) {
            return head;
        }
        head = new ListNode(0, head);
        ListNode pre = head, cur = head.next, nxt = cur.next;
        for (int i = 1; i < right; i++) {
            if (i < left) {
                pre = cur;
                cur = nxt;
                nxt = nxt.next;
            } else {
                cur.next = nxt.next;
                nxt.next = pre.next;
                pre.next = nxt;
                nxt = cur.next;
            }
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
