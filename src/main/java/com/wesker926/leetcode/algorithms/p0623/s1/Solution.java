package com.wesker926.leetcode.algorithms.p0623.s1;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author wesker.gh
 * @date 2021/12/24
 * @description bfs
 */
public class Solution {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            return new TreeNode(val, root, null);
        }

        TreeNode cur;
        int layer = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        for (depth--; depth > 1; ) {
            cur = queue.poll();
            if (cur.left != null) {
                queue.offer(cur.left);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
            }
            if ((--layer) == 0) {
                depth--;
                layer = queue.size();
            }
        }

        while (!queue.isEmpty()) {
            cur = queue.poll();
            cur.left = new TreeNode(val, cur.left, null);
            cur.right = new TreeNode(val, null, cur.right);
        }
        return root;
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
