package com.wesker926.leetcode.algorithms.p2415.s1;

/**
 * @author wesker.gh
 * @date 2023/12/15
 * @description BFS
 */
public class Solution {
    public TreeNode reverseOddLevels(TreeNode root) {
        TreeNode[] list = new TreeNode[]{root}, temp;
        for (int layer = 0; list.length > 0; layer ^= 1, list = temp) {
            temp = new TreeNode[list[0].left == null ? 0 : (list.length << 1)];
            for (int i = 0; i < (temp.length >> 1); i++) {
                temp[i << 1] = list[i].left;
                temp[(i << 1) + 1] = list[i].right;
            }
            if (layer == 0) continue;
            for (int i = 0, j = list.length - 1; i < j; i++, j--) {
                int val = list[i].val;
                list[i].val = list[j].val;
                list[j].val = val;
            }
        }
        return root;
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
