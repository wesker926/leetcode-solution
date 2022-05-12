package com.wesker926.leetcode.algorithms.p0103.s1;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author wesker.gh
 * @date 2022/5/12
 * @description 队列 + 反转
 */
public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        if (root == null) {
            return ans;
        }
        LinkedList<Integer> cur = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>(List.of(root));
        for (int layer = 1, dir = 0; !queue.isEmpty(); ) {
            TreeNode node = queue.poll();
            if ((dir & 1) == 0) {
                cur.addLast(node.val);
            } else {
                cur.addFirst(node.val);
            }
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
            if (--layer == 0) {
                layer = queue.size();
                dir ^= 1;
                ans.add(cur);
                cur = new LinkedList<>();
            }
        }
        return ans;
    }

    private class TreeNode {

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
