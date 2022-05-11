package com.wesker926.leetcode.algorithms.p0099.s2;

/**
 * @author wesker.gh
 * @date 2022/5/11
 * @description Morris中序遍历（O(1)空间复杂度）
 */
public class Solution {
    public void recoverTree(TreeNode root) {
        TreeNode[] find = morris(root);
        swapVal(find[0], find[1]);
    }

    private TreeNode[] morris(TreeNode root) {
        TreeNode pre = null;
        TreeNode[] find = new TreeNode[2];
        while (root != null) {
            if (root.left != null) {
                TreeNode predecessor = root.left;
                while (predecessor.right != root && predecessor.right != null) {
                    predecessor = predecessor.right;
                }
                if (predecessor.right == null) {
                    predecessor.right = root;
                    root = root.left;
                } else {
                    pre = compare(pre, root, find);
                    predecessor.right = null;
                    root = root.right;
                }
                continue;
            }
            pre = compare(pre, root, find);
            root = root.right;
        }
        return find;
    }

    private TreeNode compare(TreeNode pre, TreeNode cur, TreeNode[] find) {
        if (pre != null && pre.val > cur.val) {
            if (find[0] == null) {
                find[0] = pre;
            }
            find[1] = cur;
        }
        return cur;
    }

    private void swapVal(TreeNode n1, TreeNode n2) {
        int t = n1.val;
        n1.val = n2.val;
        n2.val = t;
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
