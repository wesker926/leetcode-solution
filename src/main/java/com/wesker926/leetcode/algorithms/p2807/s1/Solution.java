package com.wesker926.leetcode.algorithms.p2807.s1;

/**
 * @author wesker.gh
 * @date 2024/1/6
 * @description 链表插入 + GCD
 */
public class Solution {
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        for (ListNode cur = head; cur.next != null; cur = cur.next.next) {
            cur.next = new ListNode(gcd(cur.val, cur.next.val), cur.next);
        }
        return head;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
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
