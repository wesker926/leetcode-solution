package com.wesker926.leetcode.algorithms.p0222.s2;

/**
 * @author wesker.gh
 * @date 2021/12/3
 * @description 二分法：子树递归
 */
public class Solution {

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = getDepth(root.left), r = getDepth(root.right);
        return l == r ? (1 << l) + countNodes(root.right) : (1 << r) + countNodes(root.left);
    }

    private int getDepth(TreeNode node) {
        int depth = 0;
        while (node != null) {
            depth++;
            node = node.left;
        }
        return depth;
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
