package com.wesker926.leetcode.algorithms.p0023.s1;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author wesker.gh
 * @date 2022/4/26
 * @description 优先级队列
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        for (ListNode list : lists) {
            if (list != null) {
                queue.add(list);
            }
        }

        ListNode head = new ListNode(), cur = head;
        while (!queue.isEmpty()) {
            cur.next = queue.poll();
            cur = cur.next;
            if (cur.next != null) {
                queue.offer(cur.next);
            }
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
