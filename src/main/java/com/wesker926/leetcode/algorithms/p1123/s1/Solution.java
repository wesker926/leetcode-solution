package com.wesker926.leetcode.algorithms.p1123.s1;

/**
 * @author wesker.gh
 * @date 2023/9/6
 * @description DFS
 * 也可以只DFS一遍，同时拿节点和深度
 */
public class Solution {
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        return dfs(root, 0, getDepth(root));
    }

    private int getDepth(TreeNode node) {
        return node == null ? -1 : Math.max(getDepth(node.left), getDepth(node.right)) + 1;
    }

    private TreeNode dfs(TreeNode node, int depth, int maxDepth) {
        if (node == null) return null;
        if (depth++ == maxDepth) return node;
        TreeNode l = dfs(node.left, depth, maxDepth), r = dfs(node.right, depth, maxDepth);
        return l != null && r != null ? node : (l != null ? l : r);
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
