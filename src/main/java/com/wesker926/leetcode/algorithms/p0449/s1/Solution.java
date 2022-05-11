package com.wesker926.leetcode.algorithms.p0449.s1;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author wesker.gh
 * @date 2022/5/11
 * @description 通用二叉树 - 队列迭代法
 */
public class Solution {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder("[");
        Queue<TreeNode> queue = new LinkedList<>(List.of(root));
        for (int notNull = 1; notNull > 0 && !queue.isEmpty(); ) {
            TreeNode cur = queue.poll();
            if (cur == null) {
                sb.append("null,");
                continue;
            }
            sb.append(cur.val).append(',');
            queue.offer(cur.left);
            queue.offer(cur.right);
            notNull += (cur.left != null ? 1 : 0) + (cur.right != null ? 1 : 0) - 1;
        }
        sb.setCharAt(sb.length() - 1, ']');
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() <= 2) {
            return null;
        }
        String[] sp = data.substring(1, data.length() - 1).split(",");
        TreeNode root = new TreeNode(Integer.parseInt(sp[0]));
        Queue<TreeNode> queue = new LinkedList<>(List.of(root));
        for (int i = 1; i < sp.length && !queue.isEmpty(); i += 2) {
            TreeNode cur = queue.poll();
            if (!"null".equals(sp[i])) {
                cur.left = new TreeNode(Integer.parseInt(sp[i]));
                queue.offer(cur.left);
            }
            if (i != sp.length - 1 && !"null".equals(sp[i + 1])) {
                cur.right = new TreeNode(Integer.parseInt(sp[i + 1]));
                queue.offer(cur.right);
            }
        }
        return root;
    }

    private static class TreeNode {

        int val;

        TreeNode left;

        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
