package com.wesker926.leetcode.algorithms.p0965.s1;

/**
 * @author wesker.gh
 * @date 2022/5/24
 * @description DFS
 */
public class Solution {
    public boolean isUnivalTree(TreeNode root) {
        return root == null || dfs(root, root.val);
    }

    private boolean dfs(TreeNode node, int pre) {
        return node == null || (node.val == pre && dfs(node.left, pre) && dfs(node.right, pre));
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
