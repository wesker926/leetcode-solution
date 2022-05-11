package com.wesker926.leetcode.algorithms.p0100.s1;

/**
 * @author wesker.gh
 * @date 2022/5/11
 * @description DFS
 */
public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return (p == null && q == null) ||
                (p != null && q != null && p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right));
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
