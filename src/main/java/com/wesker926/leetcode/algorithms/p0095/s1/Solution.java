package com.wesker926.leetcode.algorithms.p0095.s1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author wesker.gh
 * @date 2022/5/9
 * @description DP
 */
public class Solution {

    private static final List<List<TreeNode>> CACHE = new ArrayList<>(List.of(List.of(new TreeNode(1))));

    public List<TreeNode> generateTrees(int n) {
        for (int i = CACHE.size(); i < n; i++) {
            List<TreeNode> preList = CACHE.get(i - 1);
            List<TreeNode> curList = new LinkedList<>();
            CACHE.add(curList);
            for (TreeNode node : preList) {
                node = new TreeNode(0, null, node);
                TreeNode insert = new TreeNode(i + 1), cur = node;
                for (; cur != null; cur = cur.right) {
                    insert.left = cur.right;
                    cur.right = insert;
                    curList.add(copy(node.right));
                    cur.right = insert.left;
                    insert.left = null;
                }
            }
        }
        return CACHE.get(n - 1);
    }

    private TreeNode copy(TreeNode node) {
        return node == null ? null : new TreeNode(node.val, copy(node.left), copy(node.right));
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
