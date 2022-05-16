package com.wesker926.leetcode.algorithms.p0113.s1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author wesker.gh
 * @date 2022/5/16
 * @description DFS
 */
public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        return dfs(new LinkedList<>(), new LinkedList<>(), root, targetSum);
    }

    private List<List<Integer>> dfs(List<List<Integer>> ans, LinkedList<Integer> path, TreeNode root, int tar) {
        if (root == null) {
            return ans;
        }
        path.add(root.val);
        if (root.left == null && root.right == null) {
            if (root.val == tar) {
                ans.add(new ArrayList<>(path));
            }
        } else {
            dfs(ans, path, root.left, tar - root.val);
            dfs(ans, path, root.right, tar - root.val);
        }
        path.removeLast();
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
