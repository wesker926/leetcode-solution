package com.wesker926.leetcode.algorithms.p0160.s2;

/**
 * @author wesker.gh
 * @date 2022/6/2
 * @description 双指针
 * 每个指针先后遍历两条链表，这样可以抹平长度差
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode n1 = headA, n2 = headB;
        while (n1 != n2) {
            n1 = n1 == null ? headB : n1.next;
            n2 = n2 == null ? headA : n2.next;
        }
        return n1;
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
