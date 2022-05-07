package com.wesker926.leetcode.algorithms.p0086.s1;

/**
 * @author wesker.gh
 * @date 2022/5/7
 * @description 模拟
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode l1 = new ListNode(), l2 = new ListNode();
        ListNode cur1 = l1, cur2 = l2;
        for (; head != null; head = head.next) {
            if (head.val < x) {
                cur1.next = head;
                cur1 = cur1.next;
            } else {
                cur2.next = head;
                cur2 = cur2.next;
            }
        }
        cur2.next = null;
        cur1.next = l2.next;
        return l1.next;
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
