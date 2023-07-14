package com.wesker926.leetcode.algorithms.p0979.s1;

/**
 * @author wesker.gh
 * @date 2023/7/14
 * @description DFS
 */
public class Solution {

    public int ans;

    public int distributeCoins(TreeNode root) {
        ans = 0;
        dfs(root);
        return ans;
    }

    private int dfs(TreeNode root) {
        if (root == null) return 0;
        int cur = root.val - 1 + dfs(root.left) + dfs(root.right);
        ans += Math.abs(cur);
        return cur;
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
