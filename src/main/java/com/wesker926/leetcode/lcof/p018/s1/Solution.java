package com.wesker926.leetcode.lcof.p018.s1;

/**
 * @author wesker.gh
 * @date 2022/4/2
 * @description 遍历
 */
public class Solution {
    public ListNode deleteNode(ListNode head, int val) {
        ListNode cur = new ListNode(-1);
        cur.next = head;
        head = cur;
        for (; cur.next != null; cur = cur.next) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
                break;
            }
        }
        return head.next;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
