package com.wesker926.leetcode.algorithms.p0508.s1;

import java.util.*;

/**
 * @author wesker.gh
 * @date 2022/6/19
 * @description DFS
 */
public class Solution {

    private int maxCount;

    private Map<Integer, Integer> counts;

    public int[] findFrequentTreeSum(TreeNode root) {
        maxCount = 0;
        counts = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        dfs(root, res);
        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }

    private int dfs(TreeNode node, List<Integer> ans) {
        if (node == null) {
            return 0;
        }
        int val = node.val + dfs(node.left, ans) + dfs(node.right, ans);
        int count = counts.getOrDefault(val, 0) + 1;
        counts.put(val, count);
        if (count >= maxCount) {
            if (count > maxCount) {
                ans.clear();
            }
            maxCount = count;
            ans.add(val);
        }
        return val;
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
