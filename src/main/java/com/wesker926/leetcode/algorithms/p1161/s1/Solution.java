package com.wesker926.leetcode.algorithms.p1161.s1;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author wesker.gh
 * @date 2022/7/31
 * @description BFS
 */
public class Solution {
    public int maxLevelSum(TreeNode root) {
        int ans = 1, max = root.val;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        for (int level = 0, sum = 0, layer = 1; !queue.isEmpty(); ) {
            TreeNode cur = queue.poll();
            sum += cur.val;
            if (cur.left != null) {
                queue.offer(cur.left);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
            }
            if (--layer == 0) {
                layer = queue.size();
                level++;
                if (sum > max) {
                    max = sum;
                    ans = level;
                }
                sum = 0;
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
