package com.wesker926.leetcode.algorithms.p1026.s1;

/**
 * @author wesker.gh
 * @date 2023/4/18
 * @description DFS
 * 思路一：对每个节点维护其祖先的最大最小值
 * 思路二：对每个节点维护其后代的最大最小值
 */
public class Solution {
    public int maxAncestorDiff(TreeNode root) {
        return dfs(root)[0];
    }

    private int[] dfs(TreeNode node) {
        if (node == null) {
            return new int[]{0, -1, 100001};
        }
        if (node.left == null && node.right == null) {
            return new int[]{0, node.val, node.val};
        }
        int[] left = dfs(node.left), right = dfs(node.right);
        int ans = Math.max(left[0], right[0]), max = Math.max(left[1], right[1]), min = Math.min(left[2], right[2]);
        ans = Math.max(ans, Math.max(Math.abs(node.val - max), Math.abs(node.val - min)));
        return new int[]{ans, Math.max(max, node.val), Math.min(min, node.val)};
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
