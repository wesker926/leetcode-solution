package com.wesker926.leetcode.algorithms.p1080.s1;

/**
 * @author wesker.gh
 * @date 2023/5/22
 * @description DFS
 */
public class Solution {
    public TreeNode sufficientSubset(TreeNode root, int limit) {
        root = new TreeNode(0, root, null);
        dfs(root, 0, limit);
        return root.left;
    }

    private boolean dfs(TreeNode node, int parent, int limit) {
        if (node == null) return false;
        int cur = parent + node.val;
        if (node.left == null && node.right == null) return cur >= limit;
        boolean l = dfs(node.left, cur, limit), r = dfs(node.right, cur, limit);
        if (!l) node.left = null;
        if (!r) node.right = null;
        return l || r;
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
