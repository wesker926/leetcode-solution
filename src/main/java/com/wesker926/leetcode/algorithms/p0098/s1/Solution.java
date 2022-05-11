package com.wesker926.leetcode.algorithms.p0098.s1;

/**
 * @author wesker.gh
 * @date 2022/5/11
 * @description 子树递归
 */
public class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValid(root, Long.MAX_VALUE, Long.MIN_VALUE);
    }

    private boolean isValid(TreeNode node, long max, long min) {
        return node == null ||
                (node.val > min && node.val < max && isValid(node.left, node.val, min) && isValid(node.right, max, node.val));
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
