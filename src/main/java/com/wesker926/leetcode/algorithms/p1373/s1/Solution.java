package com.wesker926.leetcode.algorithms.p1373.s1;

/**
 * @author wesker.gh
 * @date 2023/5/20
 * @description DFS
 */
public class Solution {

    private static final int INF = Integer.MAX_VALUE;

    public int maxSumBST(TreeNode root) {
        int[] max = new int[]{0};
        dfs(root, max);
        return max[0];
    }

    private int[] dfs(TreeNode node, int[] max) {
        if (node.left == null && node.right == null) {
            max[0] = Math.max(max[0], node.val);
            return new int[]{node.val, node.val, node.val};
        }

        int[] l = new int[]{0, node.val, node.val}, r = l;
        if (node.left != null) {
            l = dfs(node.left, max);
            if (l[0] != INF && node.val <= l[1]) l[0] = INF;
        }
        if (node.right != null) {
            r = dfs(node.right, max);
            if (r[0] != INF && node.val >= r[2]) r[0] = INF;
        }

        int[] cur = new int[]{INF, 0, 0};
        if (l[0] == INF || r[0] == INF) return cur;
        cur[0] = l[0] + r[0] + node.val;
        cur[1] = r[1];
        cur[2] = l[2];
        max[0] = Math.max(max[0], cur[0]);
        return cur;
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
