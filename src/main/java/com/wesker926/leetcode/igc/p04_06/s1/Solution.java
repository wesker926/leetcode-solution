package com.wesker926.leetcode.igc.p04_06.s1;

import java.util.LinkedList;

/**
 * @author wesker.gh
 * @date 2022/5/16
 * @description 迭代中序遍历
 */
public class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        for (TreeNode pre = null; !stack.isEmpty() || root != null; ) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (pre == p) {
                return root;
            }
            pre = root;
            root = root.right;
        }
        return null;
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
