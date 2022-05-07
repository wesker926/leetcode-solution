package com.wesker926.leetcode.algorithms.p0082.s1;

/**
 * @author wesker.gh
 * @date 2022/5/7
 * @description 遍历
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        head = new ListNode(-1, head);
        for (ListNode pre = head, cur = head.next; cur != null; cur = cur.next) {
            if (cur.next == null || cur.val != cur.next.val) {
                if (pre.next == cur) {
                    pre = cur;
                } else {
                    pre.next = cur.next;
                }
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
