package com.wesker926.leetcode.algorithms.p0098.s2;

/**
 * @author wesker.gh
 * @date 2022/5/11
 * @description 中序递归
 */
public class Solution {
    public boolean isValidBST(TreeNode root) {
        return inorder(root, new Integer[]{null});
    }

    private boolean inorder(TreeNode node, Integer[] pre) {
        if (node == null) {
            return true;
        }

        if (!inorder(node.left, pre) || (pre[0] != null && node.val <= pre[0])) {
            return false;
        }
        pre[0] = node.val;
        return inorder(node.right, pre);
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
