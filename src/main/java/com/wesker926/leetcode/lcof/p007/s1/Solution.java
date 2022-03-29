package com.wesker926.leetcode.lcof.p007.s1;

/**
 * @author wesker.gh
 * @date 2022/3/29
 * @description 递归构造
 */
public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, inorder, 0, 0, preorder.length);
    }

    private TreeNode build(int[] pre, int[] in, int s1, int s2, int len) {
        if (len <= 0) {
            return null;
        }

        TreeNode cur = new TreeNode(pre[s1]);
        int leftLen = 0;
        for (; leftLen < len; leftLen++) {
            if (in[leftLen + s2] == pre[s1]) {
                break;
            }
        }
        if (leftLen != len) {
            cur.left = build(pre, in, s1 + 1, s2, leftLen);
            cur.right = build(pre, in, s1 + leftLen + 1, s2 + leftLen + 1, len - leftLen - 1);
        }
        return cur;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
