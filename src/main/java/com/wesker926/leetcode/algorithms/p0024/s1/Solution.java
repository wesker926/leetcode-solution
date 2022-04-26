package com.wesker926.leetcode.algorithms.p0024.s1;

/**
 * @author wesker.gh
 * @date 2022/4/26
 * @description 迭代
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        head = new ListNode(0, head);
        for (ListNode pre = head, cur = head.next; cur != null && cur.next != null; pre = cur, cur = cur.next) {
            pre.next = cur.next;
            cur.next = cur.next.next;
            pre.next.next = cur;
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
