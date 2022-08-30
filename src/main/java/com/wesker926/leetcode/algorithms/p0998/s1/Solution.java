package com.wesker926.leetcode.algorithms.p0998.s1;

/**
 * @author wesker.gh
 * @date 2022/8/30
 * @description DFS
 * 比较右子节点
 */
public class Solution {
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        root = new TreeNode(101, null, root);
        dfs(root, val);
        return root.right;
    }

    private void dfs(TreeNode node, int val) {
        if (node.right == null || node.right.val < val) {
            node.right = new TreeNode(val, node.right, null);
            return;
        }
        dfs(node.right, val);
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
