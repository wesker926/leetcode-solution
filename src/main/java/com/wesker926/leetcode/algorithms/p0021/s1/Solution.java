package com.wesker926.leetcode.algorithms.p0021.s1;

/**
 * @author wesker.gh
 * @date 2022/4/25
 * @description 迭代
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(), cur = head;
        for (; list1 != null && list2 != null; cur = cur.next) {
            if (list1.val <= list2.val) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
        }
        cur.next = list1 == null ? list2 : list1;
        return head.next;
    }

    public class ListNode {

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
