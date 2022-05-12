package com.wesker926.leetcode.algorithms.p0105.s1;

/**
 * @author wesker.gh
 * @date 2022/5/12
 * @description DFS + bucket
 */
public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int[] idxTable = new int[6001];
        for (int i = 0; i < inorder.length; i++) {
            idxTable[inorder[i] + 3000] = i;
        }
        return dfs(preorder, idxTable, 0, 0, preorder.length);
    }

    private TreeNode dfs(int[] preorder, int[] inorderIdxTable, int s1, int s2, int len) {
        if (len <= 0) {
            return null;
        }
        TreeNode node = new TreeNode(preorder[s1]);
        int idx = inorderIdxTable[preorder[s1] + 3000];
        int leftLen = idx - s2, rightLen = len - leftLen - 1;
        node.left = dfs(preorder, inorderIdxTable, s1 + 1, s2, leftLen);
        node.right = dfs(preorder, inorderIdxTable, s1 + leftLen + 1, idx + 1, rightLen);
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
