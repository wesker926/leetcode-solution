package com.wesker926.leetcode.algorithms.p0106.s1;

/**
 * @author wesker.gh
 * @date 2022/5/13
 * @description DFS + bucket
 * 同p0105基本一样
 */
public class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int[] idxTable = new int[6001];
        for (int i = 0; i < inorder.length; i++) {
            idxTable[inorder[i] + 3000] = i;
        }
        return dfs(postorder, idxTable, postorder.length - 1, 0, postorder.length);
    }

    private TreeNode dfs(int[] postorder, int[] inorderIdxTable, int e1, int s2, int len) {
        if (len <= 0) {
            return null;
        }
        TreeNode node = new TreeNode(postorder[e1]);
        int idx = inorderIdxTable[postorder[e1] + 3000];
        int leftLen = idx - s2, rightLen = len - leftLen - 1;
        node.left = dfs(postorder, inorderIdxTable, e1 - rightLen - 1, s2, leftLen);
        node.right = dfs(postorder, inorderIdxTable, e1 - 1, idx + 1, rightLen);
        return node;
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
