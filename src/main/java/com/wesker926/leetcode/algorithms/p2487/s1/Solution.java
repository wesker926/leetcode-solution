package com.wesker926.leetcode.algorithms.p2487.s1;

/**
 * @author wesker.gh
 * @date 2024/1/3
 * @description 单调栈
 * 反转链表后正向删除可以O(1)空间
 */
public class Solution {
    public ListNode removeNodes(ListNode head) {
        int len = 0, idx = 0;
        for (ListNode cur = head; cur != null; cur = cur.next) len++;
        ListNode[] sk = new ListNode[len];
        for (ListNode cur = head; cur != null; cur = cur.next) {
            while (idx > 0 && sk[idx - 1].val < cur.val) idx--;
            sk[idx++] = cur;
        }
        for (int i = 0; i < idx - 1; i++) sk[i].next = sk[i + 1];
        return sk[0];
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
