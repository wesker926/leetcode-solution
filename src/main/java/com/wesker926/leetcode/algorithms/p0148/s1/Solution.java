package com.wesker926.leetcode.algorithms.p0148.s1;

/**
 * @author wesker.gh
 * @date 2022/5/26
 * @description 归并排序（递归版）
 */
public class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        int len = getLength(head);
        ListNode left = head, right, cur;
        for (int i = 1; i < len / 2; i++) {
            left = left.next;
        }
        right = left.next;
        left.next = null;
        left = head;

        left = sortList(left);
        right = sortList(right);
        for (head = new ListNode(), cur = head; left != null && right != null; cur = cur.next) {
            if (left.val <= right.val) {
                cur.next = left;
                left = left.next;
            } else {
                cur.next = right;
                right = right.next;
            }
        }
        cur.next = left != null ? left : right;
        return head.next;
    }

    private int getLength(ListNode node) {
        int len = 0;
        for (; node != null; node = node.next) {
            len++;
        }
        return len;
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
