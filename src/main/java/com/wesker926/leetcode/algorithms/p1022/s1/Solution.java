package com.wesker926.leetcode.algorithms.p1022.s1;

/**
 * @author wesker.gh
 * @date 2022/5/30
 * @description DFS（递归版）
 */
public class Solution {
    public int sumRootToLeaf(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode node, int cur) {
        if (node == null) {
            return 0;
        }
        cur = (cur << 1) | node.val;
        return node.left == null && node.right == null ? cur : dfs(node.left, cur) + dfs(node.right, cur);
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
