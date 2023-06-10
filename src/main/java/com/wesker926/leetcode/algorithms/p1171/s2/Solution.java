package com.wesker926.leetcode.algorithms.p1171.s2;

/**
 * @author wesker.gh
 * @date 2023/6/11
 * @description 递归
 * 很精彩
 */
public class Solution {
    public ListNode removeZeroSumSublists(ListNode head) {
        if (head == null) return null;
        int sum = 0;
        for (ListNode cur = head; cur != null; cur = cur.next)
            if ((sum += cur.val) == 0) return removeZeroSumSublists(cur.next);
        head.next = removeZeroSumSublists(head.next);
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
