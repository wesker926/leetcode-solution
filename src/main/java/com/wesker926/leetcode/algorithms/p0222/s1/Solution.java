package com.wesker926.leetcode.algorithms.p0222.s1;

/**
 * @author wesker.gh
 * @date 2021/12/3
 * @description 二分法：位运算路径
 */
public class Solution {
    public int countNodes(TreeNode root) {
        int h = 0;
        TreeNode cur = root;
        while (cur != null) {
            h++;
            cur = cur.left;
        }
        if (h < 2) {
            return h;
        }

        int l = (int) Math.pow(2, h - 1) - 1;
        int r = l * 2, m = 0, mask = 1 << (h - 2);
        while (l <= r) {
            m = l + (r - l) / 2;
            if (check(root, m + 1, mask)) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return l;
    }

    private boolean check(TreeNode node, int bit, int mask) {
        for (; mask != 0; mask >>= 1) {
            if ((bit & mask) == 0) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return node != null;
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
