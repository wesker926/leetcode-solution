package com.wesker926.leetcode.algorithms.p0700.s1;

/**
 * @author wesker.gh
 * @date 2021/11/26
 * @description bst
 */
public class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        return root == null || root.val == val ? root : (root.val > val ? searchBST(root.left, val) : searchBST(root.right, val));
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
