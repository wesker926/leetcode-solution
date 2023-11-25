package com.wesker926.leetcode.algorithms.p1457.s1;

/**
 * @author wesker.gh
 * @date 2023/11/25
 * @description DFS
 * 可用位运算优化：异或统计，判断是否为0或只有一个bit为1。
 */
public class Solution {
    public int pseudoPalindromicPaths(TreeNode root) {
        return dfs(root, new int[10]);
    }

    private int dfs(TreeNode node, int[] table) {
        if (node == null) return 0;
        int res = 0;
        table[node.val]++;
        if (node.left == null && node.right == null) {
            int odd = 0;
            for (int cnt : table) if ((cnt & 1) == 1) odd++;
            if (odd <= 1) res = 1;
        } else {
            res = dfs(node.left, table) + dfs(node.right, table);
        }
        table[node.val]--;
        return res;
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
