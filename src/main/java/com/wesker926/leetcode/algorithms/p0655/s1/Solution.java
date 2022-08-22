package com.wesker926.leetcode.algorithms.p0655.s1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wesker.gh
 * @date 2022/8/22
 * @description DFS
 */
public class Solution {
    public List<List<String>> printTree(TreeNode root) {
        int m = getHeight(root), n = (int) Math.pow(2, m) - 1;
        List<List<String>> ans = new ArrayList<>(m);
        for (int i = 0; i < m; i++) {
            List<String> element = new ArrayList<>(n);
            for (int j = 0; j < n; j++) {
                element.add("");
            }
            ans.add(element);
        }
        return buildTreeList(root, 0, n / 2, ans);
    }

    private int getHeight(TreeNode node) {
        return node == null ? 0 : Math.max(getHeight(node.left), getHeight(node.right)) + 1;
    }

    private List<List<String>> buildTreeList(TreeNode node, int depth, int idx, List<List<String>> ans) {
        if (node == null) {
            return ans;
        }
        ans.get(depth).set(idx, String.valueOf(node.val));
        int diff = (int) Math.pow(2, ans.size() - depth - 2);
        buildTreeList(node.left, depth + 1, idx - diff, ans);
        buildTreeList(node.right, depth + 1, idx + diff, ans);
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
