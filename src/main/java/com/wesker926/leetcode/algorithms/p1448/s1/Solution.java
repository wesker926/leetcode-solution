package com.wesker926.leetcode.algorithms.p1448.s1;

/**
 * @author wesker.gh
 * @date 2023/8/25
 * @description DFS
 */
public class Solution {
    public int goodNodes(TreeNode root) {
        return dfs(root, Integer.MIN_VALUE);
    }

    private int dfs(TreeNode node, int max) {
        if (node == null) return 0;
        int cur = node.val >= max ? 1 : 0;
        max = Math.max(max, node.val);
        return cur + dfs(node.left, max) + dfs(node.right, max);
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
