package com.wesker926.leetcode.algorithms.p1609.s1;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author wesker.gh
 * @date 2021/12/25
 * @description bfs
 */
public class Solution {
    public boolean isEvenOddTree(TreeNode root) {
        TreeNode cur;
        boolean evenLevel = true;
        int layer = 1, pre = Integer.MIN_VALUE;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            cur = queue.poll();
            if (evenLevel) {
                if ((cur.val & 1) == 0 || cur.val <= pre) {
                    return false;
                }
            } else {
                if ((cur.val & 1) == 1 || cur.val >= pre) {
                    return false;
                }
            }
            pre = cur.val;

            if (cur.left != null) {
                queue.offer(cur.left);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
            }

            if ((--layer) == 0) {
                layer = queue.size();
                evenLevel = !evenLevel;
                pre = evenLevel ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
        }
        return true;
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
