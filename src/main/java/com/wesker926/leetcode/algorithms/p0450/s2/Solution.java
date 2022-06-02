package com.wesker926.leetcode.algorithms.p0450.s2;

/**
 * @author wesker.gh
 * @date 2022/6/2
 * @description 找到后继节点后替换（迭代）
 * 不会增加树高度
 */
public class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        root = new TreeNode(0, null, root);
        TreeNode pre = root, cur = root.right;
        while (cur != null) {
            if (cur.val == key) {
                break;
            } else if (cur.val > key) {
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
        if (cur.left == null || cur.right == null) {
            cur = cur.left == null ? cur.right : cur.left;
        } else {
            TreeNode successor = cur.right, successorPre = cur;
            while (successor.left != null) {
                successorPre = successor;
                successor = successor.left;
            }
            if (successorPre == cur) {
                successorPre.right = successor.right;
            } else {
                successorPre.left = successor.right;
            }
            successor.right = cur.right;
            successor.left = cur.left;
            cur = successor;
        }
        if (pre.left != null && pre.left.val == key) {
            pre.left = cur;
        } else {
            pre.right = cur;
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
