package com.wesker926.leetcode.algorithms.p0111.s1;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author wesker.gh
 * @date 2022/5/16
 * @description BFS
 */
public class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int minDepth = 1;
        Queue<TreeNode> queue = new LinkedList<>(List.of(root));
        for (int layer = 1; !queue.isEmpty(); ) {
            TreeNode cur = queue.poll();
            if (cur.left == null && cur.right == null) {
                break;
            }
            if (cur.left != null) {
                queue.offer(cur.left);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
            }
            if (--layer == 0) {
                layer = queue.size();
                minDepth++;
            }
        }
        return minDepth;
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
