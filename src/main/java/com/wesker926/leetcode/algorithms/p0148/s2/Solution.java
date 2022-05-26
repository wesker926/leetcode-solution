package com.wesker926.leetcode.algorithms.p0148.s2;

/**
 * @author wesker.gh
 * @date 2022/5/26
 * @description 归并排序（迭代版）
 */
public class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        int len = 0;
        for (ListNode cur = head; cur != null; cur = cur.next) {
            len++;
        }
        head = new ListNode(0, head);
        for (int i = 1; i < len; i <<= 1) {
            ListNode pre = head, cur = pre.next, n1, n2;
            while (cur != null) {
                n1 = cur;
                for (int j = 0; j < i && cur != null; j++) {
                    cur = cur.next;
                }
                n2 = cur;
                pre = merge(pre, n1, n2, i);
                cur = pre.next;
            }
        }
        return head.next;
    }

    private ListNode merge(ListNode pre, ListNode n1, ListNode n2, int len) {
        for (int l1 = 0, l2 = 0; ; pre = pre.next) {
            if (l1 < len && n1 != null && (n2 == null || l2 == len || n1.val <= n2.val)) {
                pre.next = n1;
                n1 = n1.next;
                l1++;
            } else if (l2 < len && n2 != null && (n1 == null || l1 == len || n1.val > n2.val)) {
                pre.next = n2;
                n2 = n2.next;
                l2++;
            } else {
                break;
            }
        }
        pre.next = n2;
        return pre;
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
