package com.wesker926.leetcode.algorithms.p0445.s1;

import java.util.LinkedList;

/**
 * @author wesker.gh
 * @date 2023/7/3
 * @description 栈
 * 也可以先反转再计算
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        LinkedList<ListNode> stack1 = new LinkedList<>(), stack2 = new LinkedList<>();
        for (; l1 != null; l1 = l1.next) stack1.push(l1);
        for (; l2 != null; l2 = l2.next) stack2.push(l2);
        int carry = 0;
        ListNode node = null;
        for (; !stack1.isEmpty() || !stack2.isEmpty() || carry != 0; carry /= 10) {
            if (!stack1.isEmpty()) carry += stack1.pop().val;
            if (!stack2.isEmpty()) carry += stack2.pop().val;
            node = new ListNode(carry % 10, node);
        }
        return node;
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
