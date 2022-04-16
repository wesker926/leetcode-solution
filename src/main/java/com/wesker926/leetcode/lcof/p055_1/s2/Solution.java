package com.wesker926.leetcode.lcof.p055_1.s2;

/**
 * @author wesker.gh
 * @date 2022/4/16
 * @description DFS
 */
public class Solution {
    public int maxDepth(TreeNode root) {
        return root == null ? 0 : Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    private static class TreeNode {
        int val;

        TreeNode left;

        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
