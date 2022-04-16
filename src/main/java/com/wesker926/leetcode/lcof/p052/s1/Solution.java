package com.wesker926.leetcode.lcof.p052.s1;

/**
 * @author wesker.gh
 * @date 2022/4/16
 * @description 双指针对齐长度（本题无环）
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int len1 = getLen(headA), len2 = getLen(headB);
        if (len1 >= len2) {
            for (int i = len1 - len2; i > 0; i--) {
                headA = headA.next;
            }
        } else {
            for (int i = len2 - len1; i > 0; i--) {
                headB = headB.next;
            }
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
