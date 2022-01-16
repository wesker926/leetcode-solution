package com.wesker926.leetcode.algorithms.p0382.s1;

import java.util.Random;

/**
 * @author wesker.gh
 * @date 2022/1/16
 * @description 水塘抽样法
 */
public class Solution {

    private final ListNode head;

    private final Random rand;

    /**
     * Your Solution object will be instantiated and called as such:
     * Solution obj = new Solution(head);
     * int param_1 = obj.getRandom();
     */
    public Solution(ListNode head) {
        this.head = head;
        this.rand = new Random();
    }

    public int getRandom() {
        int ans = 0, cnt = 1;
        for (ListNode cur = head; cur != null; cur = cur.next) {
            if (rand.nextInt(cnt++) == 0) {
                ans = cur.val;
            }
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
