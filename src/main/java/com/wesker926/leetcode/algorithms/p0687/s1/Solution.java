package com.wesker926.leetcode.algorithms.p0687.s1;

/**
 * @author wesker.gh
 * @date 2022/9/2
 * @description DFS
 */
public class Solution {

    private int max;

    public int longestUnivaluePath(TreeNode root) {
        max = 0;
        dfs(root, 1001);
        return Math.max(max - 1, 0);
    }

    private int dfs(TreeNode node, int pVal) {
        if (node == null) {
            return 0;
        }

        int left = dfs(node.left, node.val), right = dfs(node.right, node.val);
        max = Math.max(max, left + right + 1);
        return node.val == pVal ? Math.max(left, right) + 1 : 0;
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
