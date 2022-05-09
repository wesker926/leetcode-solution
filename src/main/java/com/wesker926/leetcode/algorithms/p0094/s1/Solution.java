package com.wesker926.leetcode.algorithms.p0094.s1;

import java.util.LinkedList;
import java.util.List;

/**
 * @author wesker.gh
 * @date 2022/5/9
 * @description 递归
 */
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        dfs(ans, root);
        return ans;
    }

    private void dfs(List<Integer> ans, TreeNode node) {
        if (node == null) {
            return;
        }

        dfs(ans, node.left);
        ans.add(node.val);
        dfs(ans, node.right);
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
