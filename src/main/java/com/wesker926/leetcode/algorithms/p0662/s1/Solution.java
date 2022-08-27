package com.wesker926.leetcode.algorithms.p0662.s1;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author wesker.gh
 * @date 2022/8/27
 * @description 双队列BFS
 * 注：核心是记录索引
 * 注：DFS也可，先左后右，必然可以完全统计
 */
public class Solution {
    @SuppressWarnings("all")
    public int widthOfBinaryTree(TreeNode root) {
        int ans = 0;
        Deque<Integer> idxQueue = new LinkedList<>();
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        idxQueue.offer(0);
        nodeQueue.offer(root);
        for (int layer = 1, left = 0, right = 0; !nodeQueue.isEmpty(); ) {
            TreeNode cur = nodeQueue.poll();
            int idx = idxQueue.poll();
            if (cur.left != null) {
                nodeQueue.offer(cur.left);
                idxQueue.offer(idx * 2);
            }
            if (cur.right != null) {
                nodeQueue.offer(cur.right);
                idxQueue.offer(idx * 2 + 1);
            }
            if (--layer == 0) {
                ans = Math.max(ans, right - left + 1);
                layer = nodeQueue.size();
                left = layer == 0 ? 0 : idxQueue.peekFirst();
                right = layer == 0 ? 0 : idxQueue.peekLast();
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
