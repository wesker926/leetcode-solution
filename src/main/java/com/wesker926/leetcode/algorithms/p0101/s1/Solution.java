package com.wesker926.leetcode.algorithms.p0101.s1;

/**
 * @author wesker.gh
 * @date 2022/5/12
 * @description DFS
 */
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        return root == null || check(root.left, root.right);
    }

    private boolean check(TreeNode left, TreeNode right) {
        return (left == null && right == null) ||
                (left != null && right != null && left.val == right.val &&
                        check(left.left, right.right) && check(left.right, right.left));
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
