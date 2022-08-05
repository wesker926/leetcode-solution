package com.wesker926.leetcode.algorithms.p0623.s2;

/**
 * @author wesker.gh
 * @date 2022/8/5
 * @description DFS
 */
public class Solution {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        return depth == 1 ? new TreeNode(val, root, null) : dfs(root, val, depth, 1);
    }

    private TreeNode dfs(TreeNode node, int val, int depth, int cur) {
        if (node == null) {
            return null;
        }
        if (depth > cur + 1) {
            dfs(node.left, val, depth, cur + 1);
            dfs(node.right, val, depth, cur + 1);
            return node;
        }
        node.left = new TreeNode(val, node.left, null);
        node.right = new TreeNode(val, null, node.right);
        return node;
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
