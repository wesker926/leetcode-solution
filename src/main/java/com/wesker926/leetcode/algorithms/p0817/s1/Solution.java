package com.wesker926.leetcode.algorithms.p0817.s1;

/**
 * @author wesker.gh
 * @date 2022/10/12
 * @description 遍历
 * 找组件的起点
 */
public class Solution {
    public int numComponents(ListNode head, int[] nums) {
        int[] collection = new int[10001];
        for (int num : nums) {
            collection[num]++;
        }
        int ans = 0, cur = 0;
        for (; head != null; head = head.next) {
            if (collection[head.val] != 0) {
                if (cur == 0) {
                    ans++;
                    cur = 1;
                }
            } else {
                cur = 0;
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
