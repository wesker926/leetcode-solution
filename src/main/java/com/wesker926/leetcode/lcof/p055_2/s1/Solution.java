package com.wesker926.leetcode.lcof.p055_2.s1;

/**
 * @author wesker.gh
 * @date 2022/4/16
 * @description DFS
 */
public class Solution {
    public boolean isBalanced(TreeNode root) {
        return dfs(root) >= 0;
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int l = dfs(node.left), r = dfs(node.right);
        return l < 0 || r < 0 || Math.abs(l - r) > 1 ? -1 : Math.max(l, r) + 1;
    }

    private static class TreeNode {
        int val;

        TreeNode left;

        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
