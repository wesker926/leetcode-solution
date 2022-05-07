package com.wesker926.leetcode.algorithms.p0083.s1;

/**
 * @author wesker.gh
 * @date 2022/5/7
 * @description 遍历
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        for (ListNode pre = head, cur = head; cur != null; cur = cur.next) {
            if (cur.next == null || cur.next.val != pre.val) {
                pre.next = cur.next;
                pre = pre.next;
            }
        }
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
