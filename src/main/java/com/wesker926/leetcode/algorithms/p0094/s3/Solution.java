package com.wesker926.leetcode.algorithms.p0094.s3;

import java.util.LinkedList;
import java.util.List;

/**
 * @author wesker.gh
 * @date 2022/5/9
 * @description Morris中序遍历
 */
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        while (root != null) {
            if (root.left != null) {
                TreeNode predecessor = root.left;
                while (predecessor.right != null && predecessor.right != root) {
                    predecessor = predecessor.right;
                }
                if (predecessor.right != null) {
                    ans.add(root.val);
                    predecessor.right = null;
                    root = root.right;
                } else {
                    predecessor.right = root;
                    root = root.left;
                }
                continue;
            }
            ans.add(root.val);
            root = root.right;
        }
        return ans;
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
