package com.wesker926.leetcode.algorithms.p1038.s1;

/**
 * @author wesker.gh
 * @date 2023/12/4
 * @description DFS
 * 使用全局变量会好写很多，本质上是反序中序遍历
 */
public class Solution {
    public TreeNode bstToGst(TreeNode root) {
        dfs(root, 0);
        return root;
    }

    private int dfs(TreeNode node, int bigger) {
        if (node == null) return 0;
        int res = node.val;
        res += dfs(node.right, bigger);
        res += dfs(node.left, node.val = bigger + res);
        return res;
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
