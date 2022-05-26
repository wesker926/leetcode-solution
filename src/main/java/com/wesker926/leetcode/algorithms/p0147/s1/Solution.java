package com.wesker926.leetcode.algorithms.p0147.s1;

/**
 * @author wesker.gh
 * @date 2022/5/26
 * @description 遍历
 * 从前往后找需要修改的点，再从前往后找需要插入的位置
 */
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        head = new ListNode(0, head);
        for (ListNode cur = head.next; cur.next != null; ) {
            if (cur.next.val >= cur.val) {
                cur = cur.next;
                continue;
            }
            ListNode modify = cur.next;
            cur.next = modify.next;
            ListNode pre = head;
            for (; pre.next.val < modify.val; pre = pre.next) {
            }
            modify.next = pre.next;
            pre.next = modify;
        }
        return head.next;
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
