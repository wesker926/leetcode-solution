package com.wesker926.leetcode.algorithms.p0142.s1;

/**
 * @author wesker.gh
 * @date 2022/5/24
 * @description 快慢指针
 * 快慢指针找到交点后，快指针移动到head，两者逐步移动后会相遇在入口
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head == null ? null : head.next;
        for (; fast != null;
             slow = slow.next, fast = fast.next == null ? null : fast.next.next) {
            if (slow == fast) {
                break;
            }
        }
        if (fast == null) {
            return null;
        }
        for (fast = head, slow = slow.next; fast != slow; fast = fast.next, slow = slow.next) {
        }
        return fast;
    }

    private static class ListNode {

        int val;

        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
