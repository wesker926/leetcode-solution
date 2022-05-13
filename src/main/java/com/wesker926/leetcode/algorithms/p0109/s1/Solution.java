package com.wesker926.leetcode.algorithms.p0109.s1;

/**
 * @author wesker.gh
 * @date 2022/5/13
 * @description 分治递归（O(nlogn)）
 * 也可以先链表转数组，再递归构造，那就是O(n)，参考p0108
 */
public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        int len = 0;
        for (ListNode cur = head; cur != null; cur = cur.next) {
            len++;
        }
        return build(head, len);
    }

    private TreeNode build(ListNode head, int len) {
        if (len == 0) {
            return null;
        }
        ListNode cur = head;
        int idx = (len - 1) / 2;
        for (int i = idx; i > 0; i--) {
            cur = cur.next;
        }
        return new TreeNode(cur.val, build(head, idx), build(cur.next, len - idx - 1));
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


    private static class TreeNode {

        int val;

        TreeNode left;

        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
