package com.wesker926.leetcode.algorithms.p0513.s2;

/**
 * @author wesker.gh
 * @date 2022/6/22
 * @description DFS
 */
public class Solution {

    private int maxDepth;

    private int val;

    public int findBottomLeftValue(TreeNode root) {
        maxDepth = 0;
        val = 0;
        dfs(root, 1);
        return val;
    }

    private void dfs(TreeNode node, int depth) {
        if (node == null) {
            return;
        }
        if (node.left != null || node.right != null) {
            dfs(node.left, depth + 1);
            dfs(node.right, depth + 1);
            return;
        }
        if (depth > maxDepth) {
            maxDepth = depth;
            val = node.val;
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
