package com.wesker926.leetcode.algorithms.p2331.s1;

/**
 * @author wesker.gh
 * @date 2023/2/6
 * @description 递归
 */
public class Solution {
    public boolean evaluateTree(TreeNode root) {
        return root.val < 2 ? root.val == 1 :
                (root.val == 2 ? evaluateTree(root.left) || evaluateTree(root.right) :
                        evaluateTree(root.left) && evaluateTree(root.right));
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
