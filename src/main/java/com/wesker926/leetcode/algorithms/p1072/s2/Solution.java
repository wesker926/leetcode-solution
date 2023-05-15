package com.wesker926.leetcode.algorithms.p1072.s2;

/**
 * @author wesker.gh
 * @date 2023/5/15
 * @description 二叉树
 */
public class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        int max = 0;
        TreeNode root = new TreeNode();
        for (int[] row : matrix) {
            TreeNode cur = root;
            for (int col : row) {
                if (col == row[0]) cur = (cur.left = cur.left == null ? new TreeNode() : cur.left);
                else cur = (cur.right = cur.right == null ? new TreeNode() : cur.right);
            }
            max = Math.max(max, ++cur.val);
        }
        return max;
    }

    private static class TreeNode {
        int val;
        TreeNode left, right;
    }
}
