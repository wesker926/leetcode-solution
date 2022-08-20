package com.wesker926.leetcode.algorithms.p0654.s1;

/**
 * @author wesker.gh
 * @date 2022/8/20
 * @description DFS
 * 还有O(n)的单调栈解法
 */
public class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return dfs(nums, 0, nums.length - 1);
    }

    private TreeNode dfs(int[] nums, int l, int r) {
        if (l > r) {
            return null;
        }
        int max = nums[l], idx = l;
        for (int i = l + 1; i <= r; i++) {
            if (max < nums[i]) {
                max = nums[i];
                idx = i;
            }
        }
        return new TreeNode(max, dfs(nums, l, idx - 1), dfs(nums, idx + 1, r));
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
