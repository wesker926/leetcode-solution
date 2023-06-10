package com.wesker926.leetcode.algorithms.p1171.s1;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wesker.gh
 * @date 2023/6/11
 * @description 哈希表
 * 还可以递归处理
 */
public class Solution {
    public ListNode removeZeroSumSublists(ListNode head) {
        head = new ListNode(0, head);
        Map<Integer, ListNode> map = new HashMap<>();
        int sum = 0;
        for (ListNode cur = head; cur != null; cur = cur.next) map.put(sum = sum + cur.val, cur);
        sum = 0;
        for (ListNode cur = head; cur != null; cur = cur.next) {
            cur.next = map.get(sum = sum + cur.val).next;
        }
        return head.next;
    }

    public ListNode removeZeroSumSublists1(ListNode head) {
        head = new ListNode(0, head);
        Map<Integer, ListNode> map = new HashMap<>();
        map.put(0, head);
        int sum = 0;
        for (ListNode cur = head.next, pre, temp; cur != null; cur = cur.next) {
            if ((pre = map.get(sum = sum + cur.val)) == null) {
                map.put(sum, cur);
                continue;
            }
            temp = pre.next;
            for (int i = sum; temp != cur; temp = temp.next) {
                map.remove(i = i + temp.val);
            }
            pre.next = cur.next;
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
