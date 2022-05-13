package com.wesker926.leetcode.algorithms.p0110.s1;

/**
 * @author wesker.gh
 * @date 2022/5/13
 * @description 递归判断高度差
 */
public class Solution {
    public boolean isBalanced(TreeNode root) {
        return heightDiff(root) >= 0;
    }

    private int heightDiff(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int l = heightDiff(node.left), r = heightDiff(node.right);
        return l < 0 || r < 0 || Math.abs(l - r) > 1 ? -1 : Math.max(l, r) + 1;
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
