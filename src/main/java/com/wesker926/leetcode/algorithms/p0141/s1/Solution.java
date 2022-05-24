package com.wesker926.leetcode.algorithms.p0141.s1;

/**
 * @author wesker.gh
 * @date 2022/5/24
 * @description 快慢指针
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        for (ListNode slow = head, fast = head == null ? null : head.next;
             fast != null; slow = slow.next, fast = fast.next == null ? null : fast.next.next) {
            if (slow == fast) {
                return true;
            }
        }
        return false;
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
