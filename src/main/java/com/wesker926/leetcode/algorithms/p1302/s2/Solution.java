package com.wesker926.leetcode.algorithms.p1302.s2;

/**
 * @author wesker.gh
 * @date 2022/8/17
 * @description DFS
 */
public class Solution {

    private int maxDepth;

    private int maxSum;

    public int deepestLeavesSum(TreeNode root) {
        maxDepth = 0;
        maxSum = 0;
        dfs(root, 1);
        return maxSum;
    }

    private void dfs(TreeNode node, int depth) {
        if (node == null) {
            return;
        }
        if (depth > maxDepth) {
            maxDepth = depth;
            maxSum = node.val;
        } else if (depth == maxDepth) {
            maxSum += node.val;
        }
        dfs(node.left, depth + 1);
        dfs(node.right, depth + 1);
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
