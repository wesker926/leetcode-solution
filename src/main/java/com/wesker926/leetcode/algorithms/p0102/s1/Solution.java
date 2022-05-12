package com.wesker926.leetcode.algorithms.p0102.s1;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author wesker.gh
 * @date 2022/5/12
 * @description 队列
 */
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        if (root == null) {
            return ans;
        }
        List<Integer> cur = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>(List.of(root));
        for (int layer = 1; !queue.isEmpty(); ) {
            TreeNode node = queue.poll();
            cur.add(node.val);
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
            if (--layer == 0) {
                layer = queue.size();
                ans.add(cur);
                cur = new LinkedList<>();
            }
        }
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
