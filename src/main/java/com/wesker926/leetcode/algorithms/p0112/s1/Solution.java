package com.wesker926.leetcode.algorithms.p0112.s1;

/**
 * @author wesker.gh
 * @date 2022/5/16
 * @description DFS
 */
public class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return root != null && (root.left == null && root.right == null ? root.val == targetSum :
                hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val));
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
