package com.wesker926.leetcode.algorithms.p0108.s1;

/**
 * @author wesker.gh
 * @date 2022/5/13
 * @description DFS
 */
public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return dfs(nums, 0, nums.length - 1);
    }

    private TreeNode dfs(int[] nums, int s, int e) {
        if (s > e) {
            return null;
        }
        int m = s + (e - s) / 2;
        return new TreeNode(nums[m], dfs(nums, s, m - 1), dfs(nums, m + 1, e));
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
