package com.wesker926.leetcode.lcof.p054.s1;

/**
 * @author wesker.gh
 * @date 2022/4/16
 * @description 中序遍历（递归）
 */
public class Solution {

    private int k;

    private int ans;

    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        this.ans = 0;
        dfs(root);
        return this.ans;
    }

    private void dfs(TreeNode node) {
        if (node == null || k == 0) {
            return;
        }

        dfs(node.right);
        if (k-- == 1) {
            this.ans = node.val;
        }
        dfs(node.left);
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
