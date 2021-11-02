package com.wesker926.leetcode.algorithms.p0237.s1;

/**
 * @author wesker.gh
 * @date 2021/11/2
 * @description 顶替
 */
public class Solution {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
