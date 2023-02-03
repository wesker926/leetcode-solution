package com.wesker926.leetcode.algorithms.p1145.s1;

/**
 * @author wesker.gh
 * @date 2023/2/3
 * @description DFS
 * 以X为中心分成三块儿，任意一块儿超过总数的一半即符合。
 */
public class Solution {
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        int[] children = new int[2];
        int total = getCount(root, x, children) - 1;
        int parent = total - children[0] - children[1], half = total >> 1;
        return parent > half || children[0] > half || children[1] > half;
    }

    private int getCount(TreeNode node, int x, int[] children) {
        if (node == null) {
            return 0;
        }
        int l = getCount(node.left, x, children), r = getCount(node.right, x, children);
        if (node.val == x) {
            children[0] = l;
            children[1] = r;
        }
        return l + r + 1;
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
