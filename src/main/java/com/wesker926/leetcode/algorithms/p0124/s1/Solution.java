package com.wesker926.leetcode.algorithms.p0124.s1;

/**
 * @author wesker.gh
 * @date 2022/5/20
 * @description DFS
 */
public class Solution {
    public int maxPathSum(TreeNode root) {
        int[] ans = new int[]{root.val};
        dfs(root, ans);
        return ans[0];
    }

    private int dfs(TreeNode node, int[] ans) {
        if (node == null) {
            return 0;
        }
        int l = dfs(node.left, ans), r = dfs(node.right, ans);
        ans[0] = Math.max(ans[0], l + r + node.val);
        return Math.max(Math.max(l, r) + node.val, 0);
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
