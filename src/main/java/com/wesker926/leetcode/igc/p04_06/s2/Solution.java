package com.wesker926.leetcode.igc.p04_06.s2;

/**
 * @author wesker.gh
 * @date 2022/5/16
 * @description BST检索
 */
public class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode ans = null;
        if (p.right != null) {
            for (ans = p.right; ans.left != null; ans = ans.left) {
            }
            return ans;
        }
        while (root != null) {
            if (root.val > p.val) {
                ans = root;
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return ans;
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
