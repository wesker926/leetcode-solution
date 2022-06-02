package com.wesker926.leetcode.algorithms.p0450.s1;

/**
 * @author wesker.gh
 * @date 2022/6/2
 * @description 左子树附加到后继节点左侧（迭代）
 * 这种写法会增加树高度
 */
public class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        root = new TreeNode(0, null, root);
        TreeNode pre = root, cur = root.right;
        while (cur != null) {
            if (key == cur.val) {
                break;
            } else if (key < cur.val) {
                pre = cur;
                cur = cur.left;
            } else {
                pre = cur;
                cur = cur.right;
            }
        }
        if (cur == null) {
            return root.right;
        }

        TreeNode keep;
        if (cur.left == null || cur.right == null) {
            keep = cur.left == null ? cur.right : cur.left;
        } else {
            keep = cur.right;
            TreeNode temp = keep;
            while (temp.left != null) {
                temp = temp.left;
            }
            temp.left = cur.left;
        }
        if (pre.left == cur) {
            pre.left = keep;
        } else {
            pre.right = keep;
        }
        return root.right;
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
