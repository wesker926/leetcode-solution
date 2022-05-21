package com.wesker926.leetcode.algorithms.p0129.s1;

/**
 * @author wesker.gh
 * @date 2022/5/21
 * @description DFS
 */
public class Solution {
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode root, int cur) {
        if (root == null) {
            return 0;
        }
        cur = cur * 10 + root.val;
        return root.left == null && root.right == null ? cur : dfs(root.left, cur) + dfs(root.right, cur);
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
