package com.wesker926.leetcode.lcof.p006.s1;

/**
 * @author wesker.gh
 * @date 2021/10/28
 * @description print linked list
 */
public class Solution {
    public int[] reversePrint(ListNode head) {
        int count = 0;
        ListNode cur = head;
        for (; cur != null; cur = cur.next) {
            count++;
        }

        cur = head;
        int[] result = new int[count];
        for (int i = count - 1; i >= 0; i--, cur = cur.next) {
            result[i] = cur.val;
        }
        return result;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
