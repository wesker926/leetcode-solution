package com.wesker926.leetcode.algorithms.p0114.s1;

/**
 * @author wesker.gh
 * @date 2022/5/16
 * @description DFS
 */
public class Solution {
    public void flatten(TreeNode root) {
        dfs(root, new TreeNode());
    }

    private TreeNode dfs(TreeNode cur, TreeNode pre) {
        if (cur == null) {
            return pre;
        }
        pre.left = null;
        pre.right = cur;
        TreeNode left = cur.left, right = cur.right;
        return dfs(right, dfs(left, cur));
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
