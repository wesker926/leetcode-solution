package com.wesker926.leetcode.algorithms.p0025.s1;

/**
 * @author wesker.gh
 * @date 2022/4/26
 * @description 模拟
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k < 2) {
            return head;
        }
        head = new ListNode(0, head);
        ListNode st = head, ed = head, pre, cur, temp;
        for (; ; ) {
            for (int i = 0; i < k; i++) {
                ed = ed.next;
                if (ed == null) {
                    return head.next;
                }
            }
            pre = ed.next;
            cur = st.next;
            while (pre != ed) {
                temp = cur.next;
                cur.next = pre;
                pre = cur;
                cur = temp;
            }
            ed = st.next;
            st.next = pre;
            st = ed;
        }
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
