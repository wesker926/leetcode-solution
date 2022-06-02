package com.wesker926.leetcode.algorithms.p0160.s1;

/**
 * @author wesker.gh
 * @date 2022/6/2
 * @description 双指针
 * 先获取长度，对其后双指针
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int len1 = getLen(headA), len2 = getLen(headB);
        if (len1 < len2) {
            ListNode temp = headA;
            headA = headB;
            headB = temp;
        }
        for (int i = 0; i < Math.abs(len1 - len2); i++) {
            headA = headA.next;
        }
        for (; headA != null; headA = headA.next, headB = headB.next) {
            if (headA == headB) {
                return headA;
            }
        }
        return null;
    }

    private int getLen(ListNode node) {
        int len = 0;
        for (; node != null; node = node.next) {
            len++;
        }
        return len;
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
