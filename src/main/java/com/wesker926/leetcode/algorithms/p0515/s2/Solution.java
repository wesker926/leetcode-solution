package com.wesker926.leetcode.algorithms.p0515.s2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wesker.gh
 * @date 2022/6/24
 * @description DFS
 */
public class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        dfs(root, 1, ans);
        return ans;
    }

    private void dfs(TreeNode node, int depth, List<Integer> ans) {
        if (node == null) {
            return;
        }
        if (ans.size() < depth) {
            ans.add(node.val);
        } else if (ans.get(depth - 1) < node.val) {
            ans.set(depth - 1, node.val);
        }
        dfs(node.left, depth + 1, ans);
        dfs(node.right, depth + 1, ans);
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
