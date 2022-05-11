package com.wesker926.leetcode.algorithms.p0099.s1;

/**
 * @author wesker.gh
 * @date 2022/5/11
 * @description 中序递归（O(n)空间复杂度）
 */
public class Solution {
    public void recoverTree(TreeNode root) {
        TreeNode[] find = new TreeNode[2];
        inorder(root, new TreeNode[1], find);
        swapVal(find[0], find[1]);
    }

    private void inorder(TreeNode node, TreeNode[] pre, TreeNode[] find) {
        if (node == null) {
            return;
        }
        inorder(node.left, pre, find);
        if (pre[0] != null && pre[0].val > node.val) {
            if (find[0] == null) {
                find[0] = pre[0];
            }
            find[1] = node;
        }
        pre[0] = node;
        inorder(node.right, pre, find);
    }

    private void swapVal(TreeNode n1, TreeNode n2) {
        int t = n1.val;
        n1.val = n2.val;
        n2.val = t;
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
