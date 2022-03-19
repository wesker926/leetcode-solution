package com.wesker926.leetcode.algorithms.p0606.s1;

/**
 * @author wesker.gh
 * @date 2022/3/19
 * @description DFS
 */
public class Solution {
    public String tree2str(TreeNode root) {
        return root == null ? "()" : dfs(root, new StringBuilder()).toString();
    }

    private StringBuilder dfs(TreeNode node, StringBuilder sb) {
        sb.append(node.val);
        if (node.left == null && node.right == null) {
            return sb;
        }
        sb.append('(');
        if (node.left != null) {
            dfs(node.left, sb);
        }
        sb.append(')');
        if (node.right != null) {
            sb.append('(');
            dfs(node.right, sb);
            sb.append(')');
        }
        return sb;
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
