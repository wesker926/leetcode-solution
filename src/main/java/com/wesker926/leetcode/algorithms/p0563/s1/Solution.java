package com.wesker926.leetcode.algorithms.p0563.s1;

/**
 * @author wesker.gh
 * @date 2021/11/18
 * @description TODO @wesker.gh
 */
public class Solution {

    private int gradient = 0;

    public int findTilt(TreeNode root) {
        dfs(root);
        return gradient;
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int ls = dfs(node.left);
        int rs = dfs(node.right);

        gradient += Math.abs(ls - rs);
        return ls + rs + node.val;
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
