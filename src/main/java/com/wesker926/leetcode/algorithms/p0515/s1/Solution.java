package com.wesker926.leetcode.algorithms.p0515.s1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author wesker.gh
 * @date 2022/6/24
 * @description BFS
 */
public class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        for (int layer = 1, max = root.val; !queue.isEmpty(); ) {
            TreeNode cur = queue.poll();
            max = Math.max(max, cur.val);
            if (cur.left != null) {
                queue.offer(cur.left);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
            }
            if (--layer == 0) {
                ans.add(max);
                layer = queue.size();
                if (layer != 0) {
                    max = queue.peek().val;
                }
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
