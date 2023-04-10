package com.wesker926.leetcode.algorithms.p1019.s1;

import java.util.LinkedList;

/**
 * @author wesker.gh
 * @date 2023/4/10
 * @description 单调栈
 */
public class Solution {
    public int[] nextLargerNodes(ListNode head) {
        int n = 0;
        for (ListNode node = head; node != null; node = node.next, n++) ;
        int[] ans = new int[n];
        LinkedList<int[]> stack = new LinkedList<>();
        for (int i = 0; head != null; head = head.next, i++) {
            while (!stack.isEmpty() && stack.peekFirst()[1] < head.val) {
                ans[stack.pop()[0]] = head.val;
            }
            stack.push(new int[]{i, head.val});
        }
        return ans;
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
