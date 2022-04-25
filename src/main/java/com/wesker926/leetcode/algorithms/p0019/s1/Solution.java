package com.wesker926.leetcode.algorithms.p0019.s1;

/**
 * @author wesker.gh
 * @date 2022/4/25
 * @description 双指针
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        head = new ListNode(0, head);
        ListNode cur = head, pre = head;
        for (int i = 0; i < n; i++) {
            cur = cur.next;
        }
        while (cur.next != null) {
            cur = cur.next;
            pre = pre.next;
        }
        pre.next = pre.next.next;
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
