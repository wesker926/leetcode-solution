package com.wesker926.leetcode.algorithms.p1669.s1;

/**
 * @author wesker.gh
 * @date 2023/1/30
 * @description 模拟
 */
public class Solution {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode front = list1;
        for (int i = 1; i < a; i++) {
            front = front.next;
        }
        ListNode back = front.next;
        for (front.next = list2; front.next != null; front = front.next) ;
        for (int i = a; i <= b; i++) {
            back = back.next;
        }
        front.next = back;
        return list1;
    }

    public static class ListNode {

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
